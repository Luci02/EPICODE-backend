package com.epicode.esercizio2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(MyThread.class);
	private int[] arr;
	private int indiceIniziale;
	private int indiceFinale;
	private List<Integer> listaParziali;
	
	public MyThread(int[] arr, int indiceIniziale, int indiceFinale, List<Integer> listaParziali) {
		this.arr = arr;
		this.indiceIniziale = indiceIniziale;
		this.indiceFinale = indiceFinale;
		this.listaParziali = listaParziali;
	}

	@Override
	public void run() {
		
		int sommaParziale = 0;
		
		for (int i = indiceIniziale; i < indiceFinale; i++) {
			sommaParziale += arr[i];
		}
		
		listaParziali.add(sommaParziale);
		log.info("Somma Parziale (" + indiceIniziale +" - " + indiceFinale + "): " + sommaParziale);
	}
}
