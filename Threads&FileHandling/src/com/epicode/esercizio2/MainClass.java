package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		
		Logger log = LoggerFactory.getLogger(MainClass.class);
		int[] arr = new int[3000];
		Random r = new Random();
		List<Integer> listaParziali = new ArrayList<Integer>();
		int tot = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(50);
		}
		
		Thread t1 = new Thread( new MyThread(arr, 0, 1000, listaParziali) );
		Thread t2 = new Thread( new MyThread(arr, 1000, 2000, listaParziali) );
		Thread t3 = new Thread( new MyThread(arr, 2000, 3000, listaParziali) );
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		for (Integer val : listaParziali) {
			tot += val;
		}
		
		log.info("Totale: " + tot);
	}
	
}
