package com.victoriasmuk.BeltExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.victoriasmuk.BeltExam.models.Name;
import com.victoriasmuk.BeltExam.repositories.NameRepository;

@Service
public class NameService {
	@Autowired
	private NameRepository nameRepo;
	
	public List<Name> findAll() {
		return nameRepo.findAll();
	}
	public Name findOneById(Long id) {
		Optional<Name> name = nameRepo.findById(id);
		if (name.isPresent()) {
			return name.get();
		}
		return null;
	}
	public Name findByBabyName(String babyName) {
		Name name = nameRepo.findByBabyName(babyName);
		return name;
	}
	public Name create(Name name) {
		return nameRepo.save(name);
	}
	public void validateCreate(Name name, BindingResult result) {
		Name potentialName = this.findByBabyName(name.getBabyName());
		if (potentialName != null) {
			result.rejectValue("babyName", "unique", "Name must be unique!");
		} 
	}
	public void validateUpdate(Name name, BindingResult result) {
		Name potentialName = this.findByBabyName(name.getBabyName());
		Name currentName = this.findOneById(name.getId());
		if (potentialName != null && potentialName.getBabyName() != currentName.getBabyName()) {
			System.out.println(potentialName.getBabyName());
			System.out.println(currentName.getBabyName());
			result.rejectValue("babyName", "unique", "Name must be unique!");
		} 
	}
	public Name update(Name name) {
		return nameRepo.save(name);
	}
	public void delete(Long id) {
		nameRepo.deleteById(id);
	}
}
