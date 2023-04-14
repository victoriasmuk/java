package com.victoriasmuk.BurgerTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.victoriasmuk.BurgerTracker.models.Burger;
import com.victoriasmuk.BurgerTracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Burger> burgerList = burgerService.allBurgers();
		model.addAttribute("burgerList", burgerList);
		Burger newBurger = new Burger();
		model.addAttribute("newBurger", newBurger);
		return "main.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("newBurger") Burger newBurger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burgerList", burgerService.allBurgers());
			return "main.jsp";
		} else {
			burgerService.createBurger(newBurger);
			return "redirect:/";
		}

	}
	
	@GetMapping("/burgers/edit/{id}")
	public String editBurger(@PathVariable("id") Long id, Model model) {
		Burger oneBurger = burgerService.findBurger(id);
		model.addAttribute("oneBurger", oneBurger);
		return "editPage.jsp";
	}

	@PutMapping("/process/edit/{id}")
	public String processEdit(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("oneBurger") Burger oneBurger, 
			BindingResult result
			 ) {

		if (result.hasErrors()) {
			return "editPage.jsp";
		} else {
			burgerService.updateBurger(oneBurger);
			return "redirect:/";
		}
	}
}
