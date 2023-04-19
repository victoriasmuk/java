package com.victoriasmuk.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.victoriasmuk.ProjectManager.models.LoginUser;
import com.victoriasmuk.ProjectManager.models.User;
import com.victoriasmuk.ProjectManager.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User create(User user) {
		return userRepo.save(user);
	}
	public List<User> findAll(){
		return userRepo.findAll();
	}
	public User findOneById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	public User findOneByEmail(String email) {
		User user = userRepo.findOneByEmail(email);
		return user;
	}
	public User update(User user) {
		return userRepo.save(user);
	}
	public User login(LoginUser loginUser, BindingResult result) {
		User user = this.findOneByEmail(loginUser.getEmail());
		if (user == null) {
			result.rejectValue("email", "matches", "Incorrect email!");
			return null;
		}
		if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Incorrect password!");
			return null;
		}
		return user;
	}
	public User register(User user, BindingResult result) {
		User potentialUser = userRepo.findOneByEmail(user.getEmail());
		if (potentialUser != null) {
			result.rejectValue("email", "unique", "An account with this email already exists!");
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "matches", "Passwords must match!");
			result.rejectValue("password", "matches", "Passwords must match!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
}
