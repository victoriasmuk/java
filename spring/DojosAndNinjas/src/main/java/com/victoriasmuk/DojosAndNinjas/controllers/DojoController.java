package com.victoriasmuk.DojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.victoriasmuk.DojosAndNinjas.models.Dojo;
import com.victoriasmuk.DojosAndNinjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		 return "createDojo.jsp";
	 }
	@PostMapping("dojos/process/new")
	public String processCreateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		 if(result.hasErrors()) {
			 return "createDojo.jsp";
		 }
		 dojoService.createDojo(dojo);
		 return "redirect:/";
	 }
	@GetMapping("/dojos/{id}")
	public String displayDojo(@PathVariable("id") Long id, Model model) {
		 model.addAttribute("dojo", dojoService.getOneDojo(id));
		 return "displayDojos.jsp";
	 }
}
