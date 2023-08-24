package com.epicode.adapter;

import java.time.LocalDate;

public class MainClass {
	
	public static void main(String[] args) {
		
		Info info = new Info();
		
		info.setNome("Gianni");
		info.setCognome("Celeste");
		info.DataDiNascita( LocalDate.of(1964, 6, 24) );
		
		Adapter a = new Adapter(info);
		
		UserData ud = new UserData();
		ud.getData(a);
		
		System.out.println(ud);
		
	}

}
