package com.audit.entities;

import java.io.IOException;
import java.lang.Thread;

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class Jsoup1 extends Thread {

	
	public void run() {
		Long start = System.nanoTime();
		try {
			Document doc = Jsoup.connect("https://www.facebook.com/").get();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long end = System.nanoTime();
		long elapsedTime = end - start;
		double seconds = (double) elapsedTime / 1000000000.0;
		
		
		System.out.println("--------------------------");
		System.out.println("performance est{Temp de reponse} ::"+seconds+" secondes");
		
	}

}

