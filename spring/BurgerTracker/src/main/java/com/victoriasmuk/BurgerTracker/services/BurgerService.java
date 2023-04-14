package com.victoriasmuk.BurgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.BurgerTracker.models.Burger;
import com.victoriasmuk.BurgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	private BurgerRepository burgerRepo;
	
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;
	}
	public Burger createBurger(Burger newBurger) {
		return burgerRepo.save(newBurger);
	}
	public Burger updateBurger(Burger oneBurger) {
		return burgerRepo.save(oneBurger);
	}
	public void removeBurger(Long id) {
		burgerRepo.deleteById(id);
	}
}
