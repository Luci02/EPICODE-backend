package com.epicode.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DbConnection {
	
	private String url = "jdbc:postgresql://localhost:5432/Esercizio2";
	private String user = "postgres";
	private String psw = "root";
	private Statement st;
	
	public DbConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, psw);
		st = conn.createStatement();
		System.out.println("Connessione al DB avvenuta con successo!");
	}
	
	private void createTable() throws SQLException {
		
		String query = "CREATE TABLE IF NOT EXISTS school_students("
				   + "id SERIAL PRIMARY KEY,"
				   + "name VARCHAR,"
				   + "lastname VARCHAR,"
				   + "gender VARCHAR,"
				   + "birthdate DATE,"
				   + "avg DECIMAL,"
				   + "min_vote DECIMAL,"
				   + "max_vote DECIMAL"
				   + ");";
		
		st.executeUpdate(query);
		System.out.println("Tabella \"school_students\" creata con successo!");
	}
	
	private void insertStudent(Studente s) throws SQLException {
		String query = "INSERT INTO school_students ("
				     + "name, lastname, gender, birthdate, avg, min_vote, max_vote )" 
				     + "VALUES ("
				     + s.getName() + ", "
				     + s.getLastname() + ", "
				     + s.getGender() + ", "
				     + s.getBirthdate() + ", "
				     + s.getAvg() + ", "
				     + s.getMin_vote() + ", "
				     + s.getMax_vote() + ", "
				     + ")";
		st.executeUpdate(query);
		System.out.println("Studente " + s.getName() + " " + s.getLastname() + " inserito correttamente nel DB!");
	}
	
	private void updateStudent(int id, HashMap<String, Object> s) {}
	
	private void deleteStudent(int id) throws SQLException {
		String query = "DELETE FROM school_students WHERE id="+id;
		st.executeUpdate(query);
		System.out.println("Studente rimosso dal DB con successo!");
	}

}
