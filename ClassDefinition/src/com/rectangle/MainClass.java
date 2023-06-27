package com.rectangle;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rettangolo r1 = new Rettangolo(5, 10);
		Rettangolo r2 = new Rettangolo(10, 5);
		
		Rettangolo.stampaRettangolo(r1);
		Rettangolo.stampaDueRettangoli(r1, r2);
		
	}

}
