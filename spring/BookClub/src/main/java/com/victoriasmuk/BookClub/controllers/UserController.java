package com.victoriasmuk.BookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.victoriasmuk.BookClub.models.LoginUser;
import com.victoriasmuk.BookClub.models.User;
import com.victoriasmuk.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String renderForm(@ModelAttribute("newUser") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "formLoginRegister.jsp";
	}
	
	@PostMapping("/register")
	public String processRegisterUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
		User newUser = userService.registerUser(user, result);
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "formLoginRegister.jsp";
		} else {
			session.setAttribute("userId", newUser.getId());
			session.setAttribute("userName", newUser.getUserName());
			return "redirect:/books";
		}
	}
	
	@PostMapping("/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User newUser = userService.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "formLoginRegister.jsp";
		} else {
			session.setAttribute("userId", newUser.getId());
			session.setAttribute("userName", newUser.getUserName());
			return "redirect:/books";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
