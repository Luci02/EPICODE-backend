package com.epicode.Spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.models.User;

@Configuration
public class UserConfiguration {
	
	@Bean("getUser")
	@Scope("prototype")
	public User getUser() {
		return new User();
	}

}
