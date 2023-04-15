package com.victoriasmuk.SafeTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victoriasmuk.SafeTravels.models.Expense;
import com.victoriasmuk.SafeTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String home(Model model) {
		List<Expense> expenseList = expenseService.allExpenses();
		model.addAttribute("expenseList", expenseList);
		Expense newExpense = new Expense();
		model.addAttribute("newExpense", newExpense);
		return "main.jsp";
	}
	
// CREATE ONE
	@PostMapping("/expenses/process")
	public String processForm(@Valid @ModelAttribute("newExpense") Expense newExpense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenseList", expenseService.allExpenses());
			return "main.jsp";
		} else {
			expenseService.createExpense(newExpense);
			return "redirect:/";
		}

	}
	
//	VIEW ONE
	@GetMapping("/expenses/{id}")
	public String expenseDetails(@PathVariable("id")Long id, Model model) {
		Expense oneExpense = expenseService.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "viewExpense.jsp";
	}
	
//	EDIT ONE
	@GetMapping("/expenses/edit/{id}")
	public String renderEditForm(@PathVariable("id")Long id, Model model) {
		Expense oneExpense = expenseService.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "editExpense.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String processEditForm(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("oneExpense") Expense oneExpense,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "editExpense.jsp";
		}else {
			expenseService.updateExpense(oneExpense);
			return "redirect:/expenses/{id}";
		}
	}
	
//	DELETE ONE
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id")Long id) {
		expenseService.removeExpense(id);
		return "redirect:/expenses";
	}
	
}
