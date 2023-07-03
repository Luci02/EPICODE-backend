package com.epicode.esercizi.esercizio1.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.esercizi.esercizio1.classes.Esercizio1;

public class MainClass {

	public static void main(String[] args) {

		Logger log = LoggerFactory.getLogger(MainClass.class);
		
		Esercizio1 es1 = new Esercizio1();
		
		es1.startEs1();

	}

}
