package com.epicode.esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	
	private String symbol;
	private static Logger log = LoggerFactory.getLogger(MainClass.class);
	
	public MyThread(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println( (i+1) + ". " + this.symbol );
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error( e.getMessage() );
				e.printStackTrace();
			}
		}
	}

}
