package com.epicode.main;

import java.time.LocalDate;

public class Studente {
	
	private Long id;
	private String name, lastname;
	Gender gender;
	private LocalDate birthdate;
	private Double avg, min_vote, max_vote;
	
	public Studente(String name, String lastname, Gender gender, LocalDate birthdate, Double avg,
			Double min_vote, Double max_vote) {
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}
	
	public Studente(Long id, String name, String lastname, Gender gender, LocalDate birthdate, Double avg,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
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

	@Override
	public String toString() {
		return "Studente [id=" + id + ", name=" + name + ", lastname=" + lastname + ", gender=" + gender
				+ ", birthdate=" + birthdate + ", avg=" + avg + ", min_vote=" + min_vote + ", max_vote=" + max_vote
				+ "]";
	}

}
