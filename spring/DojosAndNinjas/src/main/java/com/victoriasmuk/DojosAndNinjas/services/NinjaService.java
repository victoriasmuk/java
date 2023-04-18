package com.victoriasmuk.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.DojosAndNinjas.models.Ninja;
import com.victoriasmuk.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> getAllNinjas() {
		return ninjaRepo.findAll();
	}
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	public Ninja getOneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		return null;
	}
	public Ninja updateNinja(Ninja oneNinja) {
		return ninjaRepo.save(oneNinja);
	}
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
