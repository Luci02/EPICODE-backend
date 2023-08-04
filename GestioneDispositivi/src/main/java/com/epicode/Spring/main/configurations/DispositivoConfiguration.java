package com.epicode.Spring.main.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.main.models.Laptop;
import com.epicode.Spring.main.models.Smartphone;
import com.epicode.Spring.main.models.Tablet;

@Configuration
public class DispositivoConfiguration {
	
	@Bean("getSmartphone")
	@Scope("prototype")
	public Smartphone getSmartphone() {
		return new Smartphone();
	}
	
	@Bean("getLaptop")
	@Scope("prototype")
	public Laptop getLaptop() {
		return new Laptop();
	}
	
	@Bean("getTablet")
	@Scope("prototype")
	public Tablet getTablet() {
		return new Tablet();
	}

}
