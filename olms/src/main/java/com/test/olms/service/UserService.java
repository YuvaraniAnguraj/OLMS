package com.test.olms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.olms.entity.User;
import com.test.olms.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	PasswordEncoder passEncoder;
	
	public UserService() {
		this.passEncoder=new BCryptPasswordEncoder();
	}
	
	
	public Optional<User> findUserByUserName(String name) {
		Optional<User> user = userRepository.findByUserName(name);
		return user;
	}
	
	public User addUser(User user) {
		userRepository.save(user);
		Optional<User> userValue= userRepository.findById(user.getId());
		return userValue.get();
	}

}
