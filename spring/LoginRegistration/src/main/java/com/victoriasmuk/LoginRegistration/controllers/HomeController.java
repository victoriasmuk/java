package com.victoriasmuk.LoginRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.victoriasmuk.LoginRegistration.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("userLoggedIn", userService.getOneUser((Long) session.getAttribute("userId")));
		return "dashboard.jsp";
	}
	
}
