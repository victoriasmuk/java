package com.victoriasmuk.SafeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.SafeTravels.models.Expense;
import com.victoriasmuk.SafeTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
//	FIND ALL
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
//	CREATE
	public Expense createExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
//	READ
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense=  expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
//	UPDATE
	public Expense updateExpense(Expense oneExpense) {
		return expenseRepo.save(oneExpense);
	}
//	DELETE
	public void removeExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
