package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {
	
@SuppressWarnings("unused")
private static final Logger log = LoggerFactory.getLogger(MainClass.class);
	
	public static void main(String[] args) {
		startEs2();
	}
	
	private static void startEs2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inserisci un numero intero: ");
		int n = Integer.parseInt(sc.nextLine());
		
		List<String> myList = new ArrayList<String>();
		myList = returnNewList( generateArrayList(n) );
		
		printList(myList, false);
		
	}
	
	private static List<String> generateArrayList(int n) {
		
		Random r = new Random();
		List<String> myList = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			
			int nRand = r.nextInt(101);
			myList.add( Integer.toString(nRand) );
			
		}
		
		return myList;
		
	}

	private static List<String> returnNewList(List<String> list) {
		
		List<String> secondaryList = new ArrayList<String>();
		
		secondaryList.addAll(list);
		
		Collections.reverse(list);
		
		secondaryList.addAll( list );
		
		return secondaryList;
		
	}
	
	private static void printList(List<String> list, boolean b) {
		
		int size = list.size();
		
		System.out.println(list.toString());
		
		for (int i = 0; i < size; i++) {
			
			if(b && (i%2==0)) {
				System.out.print(list.get(i) + ", ");
			}
			
			if(!b && !(i%2==0)) {
				System.out.print(list.get(i) + ", ");
			}
			
		}
		
	};
}