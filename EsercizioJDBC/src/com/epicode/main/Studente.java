package com.epicode.main;

import java.sql.Date;

public class Studente {
	
	private Integer id;
	private String name, lastname, gender;
	private Date birthdate;
	private Double avg, min_vote, max_vote;
	
	public Studente(Integer id, String name, String lastname, String gender, Date birthdate, Double avg,
			Double min_vote, Double max_vote) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(Double min_vote) {
		this.min_vote = min_vote;
	}

	public Double getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(Double max_vote) {
		this.max_vote = max_vote;
	}

}
