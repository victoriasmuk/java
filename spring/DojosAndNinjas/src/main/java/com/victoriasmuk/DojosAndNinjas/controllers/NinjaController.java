package com.victoriasmuk.DojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.victoriasmuk.DojosAndNinjas.models.Ninja;
import com.victoriasmuk.DojosAndNinjas.services.DojoService;
import com.victoriasmuk.DojosAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;

	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoService.getAllDojos());
		return "createNinja.jsp";
	}
	
	@PostMapping("/ninjas/process/new")
	public String processCreateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.getAllDojos());
			return "createNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}
}
