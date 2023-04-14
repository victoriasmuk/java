package com.victoriasmuk.OmikujiForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String form() {
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(
			@RequestParam(value = "number") Integer number,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "career") String career,
			@RequestParam(value = "thing") String thing,
			@RequestParam(value = "message") String message,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("career", career);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		
		return "redirect:/show";
	}
	
	@GetMapping("/show")
	public String showForm() {
		return "show.jsp";
	}
}
