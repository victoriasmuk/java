package com.victoriasmuk.BeltExam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.victoriasmuk.BeltExam.models.LoginUser;
import com.victoriasmuk.BeltExam.models.Name;
import com.victoriasmuk.BeltExam.models.User;
import com.victoriasmuk.BeltExam.services.NameService;
import com.victoriasmuk.BeltExam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private NameService nameService;
	
	@GetMapping("/")
	public String renderForm(@ModelAttribute("newUser") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "formLoginRegister.jsp";
	}
	
	@PostMapping("/register")
	public String processRegisterUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
		User newUser = userService.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "formLoginRegister.jsp";
		} else {
			session.setAttribute("userId", newUser.getId());
			session.setAttribute("userName", newUser.getFirstName());
			return "redirect:/dashboard";
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
			session.setAttribute("userName", newUser.getFirstName());
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Name> nameList = nameService.findAll();
		User user = userService.findOneById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		model.addAttribute("nameList", nameList);
		model.addAttribute("userId",  (Long) session.getAttribute("userId"));
		return "dashboard.jsp";
	}
}