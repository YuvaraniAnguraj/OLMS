package com.test.olms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.test.olms.service.MyUserDetailsService;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private MyUserDetailsService userDetailsService;
	
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //	auth.userDetailsService(userDetailsService);
    }
    
}
