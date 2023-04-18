package com.victoriasmuk.LoginRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.victoriasmuk.LoginRegistration.models.LoginUser;
import com.victoriasmuk.LoginRegistration.models.User;
import com.victoriasmuk.LoginRegistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User registerUser(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "An account with this email already exists!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Passwords must match!");
			result.rejectValue("password", "matches", "Passwords must match!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User getOneUser(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		if (potentialUser.isPresent()) {
			return potentialUser.get();
		}
		return null;
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(loginUser.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "matches", "Incorrect email!");
			return null;
		}
		User existingUser = potentialUser.get();
		if (!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
			result.rejectValue("password", "matches", "Incorrect password!");
			return null;
		}
		return existingUser;
	}
}
