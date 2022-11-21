package com.test.olms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.olms.entity.SecurityUser;
import com.test.olms.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userService.findUserByUserName(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new SecurityUser(user.get());
	}
    
}