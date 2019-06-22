package com.example.concurrent.Thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		 ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		 
		 Runnable command = new Runnable() {
			public void run() {
				System.out.println("execute run method ...");
			} 
		 };
		 
		 pool.scheduleAtFixedRate(command, 10, 30, TimeUnit.SECONDS);
	}

}
