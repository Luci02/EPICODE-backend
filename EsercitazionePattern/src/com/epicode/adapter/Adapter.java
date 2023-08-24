package com.epicode.adapter;

import java.time.LocalDate;

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
		int annoAttuale = LocalDate.now().getYear();
		int annoDiNascita = this.info.getDataDiNascita().getYear(); 
		return annoAttuale - annoDiNascita;
	}

}