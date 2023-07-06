package com.epicode.esercizio;

public class Customer {
	
	long id;
	String name;
	Integer tier;
	
	public Customer(long id, String name, Integer tier) {
		this.id = id;
		this.name = name;
		this.tier = tier;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}

}
