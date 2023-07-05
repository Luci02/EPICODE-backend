package com.epicode.esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	
	private static File file = new File("doc/RegistroPresenze.txt");
	private static List<Presenza> listaPresenze = new ArrayList<Presenza>();
	
	public static void main(String[] args) throws IOException {
		salvaSuFile();
		leggiDaFile();
	}
	
	public static void salvaSuFile() throws IOException {
		FileUtils.delete(file);
		
		Presenza p1 = new Presenza("Mario Rossi", 5);
		Presenza p2 = new Presenza("Giorgio Bianchi", 7);
		Presenza p3 = new Presenza("Gianni Verdi", 7);
		
		listaPresenze.add(p1);
		listaPresenze.add(p2);
		listaPresenze.add(p3);
		
		for (Presenza presenza : listaPresenze) {
			
			String stringa;
			stringa = presenza.getNomeDipendente() + "@" + presenza.getGiorniDiPresenza()+"#";
			
			FileUtils.writeStringToFile(file, stringa, "UTF-8", true);
		}
	}
	
	public static List<Presenza> leggiDaFile() throws IOException {
		
		String textFile = FileUtils.readFileToString(file, "UTF-8");

		String[] p = textFile.split("#");

		for (String s : p) {
			System.out.println(s);
			String[] par = s.split("@");
			Presenza person = new Presenza(par[0], Integer.parseInt(par[1]));
			listaPresenze.add(person);
		}
		
		return listaPresenze;
		
	}
	
}
