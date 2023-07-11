package com.epicode.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		createTable();
	}
	
	private void createTable() throws SQLException {
		
		String query = "CREATE TABLE IF NOT EXISTS school_students("
				   + "id SERIAL PRIMARY KEY,"
				   + "name VARCHAR NOT NULL,"
				   + "lastname VARCHAR NOT NULL,"
				   + "gender VARCHAR NOT NULL,"
				   + "birthdate DATE NOT NULL,"
				   + "avg DECIMAL,"
				   + "min_vote DECIMAL,"
				   + "max_vote DECIMAL"
				   + ");";
		
		st.executeUpdate(query);
		System.out.println("Tabella \"school_students\" creata con successo!");
	}
	
	public void insertStudent(Studente s) throws SQLException {
		String query = "INSERT INTO school_students ("
				     + "name, lastname, gender, birthdate, avg, min_vote, max_vote )" 
				     + "VALUES ("
				     + "'" + s.getName() + "', "
				     + "'" + s.getLastname() + "', "
				     + "'" + s.getGender() + "', "
				     + "'" + s.getBirthdate() + "', "
				     + s.getAvg() + ", "
				     + s.getMin_vote() + ", "
				     + s.getMax_vote()
				     + ")";
		st.executeUpdate(query);
		System.out.println("Studente " + s.getName() + " " + s.getLastname() + " inserito correttamente nel DB!");
	}
	
	public void updateStudent(long id, HashMap<String, Object> s) throws SQLException {
		String query = "UPDATE school_students SET "
				   + " name = '" + s.get("name").toString() + "', "
				   + " lastname = '" + s.get("lastname").toString() + "', "
				   + " gender = '" + s.get("gender").toString() + "', "
				   + " birthdate = '" + s.get("birthdate") + "', "
				   + " avg = " + s.get("avg") + ", "
				   + " min_vote = " + s.get("min_vote") + ", "
				   + " max_vote = " + s.get("max_vote")
				   + " WHERE id = " + id;
		st.executeUpdate(query);
		System.out.println("Dati dello studente " + s.get("name") + " " + s.get("lastname") + " modificati con successo!!!");
	}
	
	public void deleteStudent(long id) throws SQLException {
		String query = "DELETE FROM school_students WHERE id = "+id;
		st.executeUpdate(query);
		System.out.println("Studente rimosso dal DB con successo!");
	}
	
	public void getBest() throws SQLException {
		String query = "SELECT * FROM school_students ORDER BY avg DESC LIMIT 1";
		ResultSet rs = st.executeQuery(query);
	}

}
