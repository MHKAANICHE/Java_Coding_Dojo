package com.codingdojo.beltexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.beltexam.models.LoginUser;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.repositories.UserRepository;

@Service 
public class UserService {
@Autowired
private UserRepository userRepo;

	// Register method
	public User register(User newUser, BindingResult result) {
		// Check email for registration :
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "email is taken !");
		}
		// Check password confirmation
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registerError", "passwords does not match !");
		}
		// If valid : Hashing password & Save to DB
		if(result.hasErrors()) {
			return null;
		}else {
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);  
		// should we hash email too ? 
		// SAVE TO DB
		return userRepo.save(newUser);
		}

	}
	
	// Login method
	public User login(LoginUser newLoginObject, BindingResult result) {
		// Check email for login:
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "email is not found !");
		}else {
			User user = potentialUser.get();
			// Check paswword for login :
			if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginError", "Invalid password !");
			}
			if(result.hasErrors()) {
				return null;
			}else {
				return user;
			}
		}


		return null;
	}

	// find user by id
	public User findById(Long id) {
		Optional<User> maybeUser = userRepo.findById(id);
		if(maybeUser.isPresent()) {
			return maybeUser.get();
		}else {
			return null;
		}
	}


}
