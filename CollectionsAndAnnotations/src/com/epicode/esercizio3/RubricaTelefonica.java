package com.epicode.esercizio3;

import java.util.HashMap;
import java.util.Set;

public class RubricaTelefonica {
	
	public static void main(String[] args) {
	
		HashMap<String, String> rubrica = new HashMap<String, String>();
		
		rubrica = addContact("Luca", "1234567890", rubrica);
		rubrica = addContact("Francesco", "8547324658", rubrica);
		rubrica = addContact("Gianfranco", "0347984604", rubrica);
		
		rubrica = removeContact("Francesco", rubrica);
		
		searchContactByNumber("0347984604", rubrica);
		
		searchContactByName("Luca", rubrica);
		
		showAllContacts(rubrica);
		
	}
	
	public static HashMap<String,String> addContact(String contact, String number, HashMap<String, String> rubrica) {
		rubrica.put(contact, number);
		return rubrica;
	}
	
	public static HashMap<String, String> removeContact(String name, HashMap<String, String> rubrica) {
		rubrica.remove(name);
		return rubrica;
	}
	
	public static void searchContactByNumber(String number, HashMap<String, String> rubrica) {

		for (String currentKey : rubrica.keySet()) {
			if( rubrica.get(currentKey) == number ) {
				System.out.println("Contatto trovato con numero [" + number + "]: " + currentKey);
			}
		}
		
	}
	
	public static void searchContactByName(String name, HashMap<String, String> rubrica) {

		System.out.println("Contatto trovato con nome [" + name + "]: " + rubrica.get(name));
		
	}

	public static void showAllContacts(HashMap<String, String> rubrica) {
		
		for (String key : rubrica.keySet()) {
			System.out.println(key + ": " + rubrica.get(key));
		}
		
	}
}
