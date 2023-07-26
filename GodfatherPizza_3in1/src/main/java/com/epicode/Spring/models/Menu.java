package com.epicode.Spring.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Menu {

	private List<PizzaBase> menuPizze = new ArrayList<PizzaBase>();
	
}
