package com.epicode.Spring.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.models.Menu;
import com.epicode.Spring.models.PizzaBase;

@Service
public class MenuService {
	
	@Autowired @Qualifier("menuBean") private ObjectProvider<Menu> menuProvider;

	public void showMenu() {
		Menu m = menuProvider.getObject();
		List<PizzaBase> menuPizze = m.getMenuPizze();
		
		menuPizze.forEach(p -> System.out.println(p));
	}

}
