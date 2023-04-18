package com.victoriasmuk.DojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.victoriasmuk.DojosAndNinjas.services.DojoService;
import com.victoriasmuk.DojosAndNinjas.services.NinjaService;

@Controller
public class HomeController {
	@Autowired
	private NinjaService ninjaService;

	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("allNinjas", ninjaService.getAllNinjas());
		model.addAttribute("allDojos", dojoService.getAllDojos());
		return "main.jsp";
	}
}
