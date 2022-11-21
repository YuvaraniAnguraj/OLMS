package com.test.olms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.olms.entity.User;
import com.test.olms.service.UserService;

@SpringBootApplication
public class OlmsApplication implements CommandLineRunner{
	
	@Autowired
	UserService userservice;

	public static void main(String[] args) {
		SpringApplication.run(OlmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setUserName("admin");
		user.setPassword(new BCryptPasswordEncoder().encode("admin"));
		user.setId(120);
		user.setActive(true);
		userservice.addUser(user);
	}

}
