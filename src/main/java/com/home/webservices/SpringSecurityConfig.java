package com.home.webservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	 @Override
	    protected void configure(HttpSecurity http) throws Exception{
		 
		 
		 	http.csrf().disable();
	        http.authorizeRequests().antMatchers("/").permitAll();
	        http.cors().disable();
	        http.headers().frameOptions().sameOrigin();
	        
	        //pepitoooooooooo
	      
	    }
}

