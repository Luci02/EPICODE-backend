package com.epicode.main;

import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			
			DbConnection db = new DbConnection();
//			Studente s1 = new Studente(
//					"Antonio",
//					"Cassano",
//					Gender.m,
//					new java.sql.Date(new java.util.Date("1982/07/12").getTime()),
//					6.5,
//					4.75,
//					7.5
//					);
//			Studente s2 = new Studente(
//					"Daniele",
//					"Adani",
//					Gender.m,
//					new java.sql.Date(new java.util.Date("1974/07/10").getTime()),
//					8.25,
//					6.5,
//					9.0
//					);
//			Studente s3 = new Studente(
//					"Diletta",
//					"Leotta",
//					Gender.f,
//					new java.sql.Date(new java.util.Date("1991/08/16").getTime()),
//					10d,
//					10d,
//					9d
//					);

//			db.insertStudent(s1);
//			db.insertStudent(s2);
//			db.insertStudent(s3);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
}
