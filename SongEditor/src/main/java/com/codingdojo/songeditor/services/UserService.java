package com.codingdojo.songeditor.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.songeditor.models.LoginUser;
import com.codingdojo.songeditor.models.User;
import com.codingdojo.songeditor.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

// Registration : create new user
// validation : email does not exist in DB 
// if true --> next validation / else / save error message with BindingResult.
// validation : ConfirmPW match Password 
// if true --> save new user / else / save error message with BindingResult.
	public User userRegistration(User user, BindingResult result) {
		// Check email :
		Optional<User> optional = userRepo.findByEmail(user.getEmail());
		if (optional.isPresent()) {
			// Save error message :
			result.rejectValue("email", "registerError", "This email all ready exist!.");
		}
		// Check confirmPW :
		if (!user.getConfirmPW().equals(user.getPassword())) {
			// Save error message :
			result.rejectValue("password", "registerError", "Confirmation & Password should match!.");
		}
		// Save newUser
		if (result.hasErrors()) {
			return null;
		} else {
			// Hash password before saving :
			String hashPW = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashPW);
			// Saving newUser:
			return userRepo.save(user);
		}
	}

// Login : find user by email
// Validation : email do exist in DB
// if true --> next validation / else / save error message with BindingResult.
// Validation : Check Password
// if true -->  session get new attribute / else / save error message with BindingResult.
	public User userLogin(LoginUser user, BindingResult result) {
		// Check email :
		Optional<User> optional = userRepo.findByEmail(user.getEmail());
		if (!optional.isPresent()) {
			// Save error message :
			result.rejectValue("email", "registerError", "This email do not exist!.");
		} else {
			// Check Password :
			User potentialUser = optional.get();
			if (!BCrypt.checkpw(user.getPassword(), potentialUser.getPassword())) {
				// Save error message :
				result.rejectValue("password", "registerError", "Invalid password!.");
			}
			if (!result.hasErrors()) {
				// validate login :
				return potentialUser;
			}
		}
		return null;
	}

// C R U D 
	public User getByID(Long id) {
		Optional<User> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

}
