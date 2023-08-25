package com.epicode.adapter;

import java.time.LocalDate;
import java.time.Period;

public class Adapter implements DataSource {
	
	private Info info;

	public Adapter(Info info) {
		super();
		this.info = info;
	}

	@Override
	public String getNomeCompleto() {
		return this.info.getNome() + " " + this.info.getCognome();
	}

	@Override
	public int getEta() {
		Period p = Period.between(this.info.getDataDiNascita(), LocalDate.now());
		return p.getYears();
	}

}