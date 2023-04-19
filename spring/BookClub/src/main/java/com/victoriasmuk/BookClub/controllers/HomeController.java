package com.victoriasmuk.BookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.victoriasmuk.BookClub.services.BookService;
import com.victoriasmuk.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/books")
	public String home(HttpSession session,Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("allBooks", bookService.getAll());
		model.addAttribute("user", userService.getOneUser((Long) session.getAttribute("userId")));
		model.addAttribute("allUsers", userService.getAll());
		return "dashboard.jsp";
	}
	
	

}
