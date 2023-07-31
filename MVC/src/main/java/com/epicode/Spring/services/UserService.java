package com.epicode.Spring.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.models.User;
import com.epicode.Spring.repositories.UserRepository;
import com.github.javafaker.Faker;

@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	@Autowired @Qualifier("getUser") ObjectProvider<User> userProvider;
	
	public void saveUser(int nUser) {
		
		Faker f = new Faker(Locale.ITALY);
		
		for (int i = 0; i < nUser; i++) {
			User u = userProvider.getObject().builder()
											.name(f.name().firstName())
											.surname(f.name().lastName())
											.username(f.name().username())
											.numTel(f.phoneNumber().phoneNumber())
											.build();
			userRepository.save( u );
		}
		
	}

	public List<User> getUsersList() {
		return (List<User>) userRepository.findAll();
	}

}
