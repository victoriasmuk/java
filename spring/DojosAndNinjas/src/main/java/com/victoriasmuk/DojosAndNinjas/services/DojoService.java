package com.victoriasmuk.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.DojosAndNinjas.models.Dojo;
import com.victoriasmuk.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	public Dojo getOneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
	public Dojo updateDojo(Dojo oneDojo) {
		return dojoRepo.save(oneDojo);
	}
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
