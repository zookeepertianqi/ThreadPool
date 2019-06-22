package com.example.concurrent.Thread.pool;

public class Worker implements Runnable {

	private int workerNo;
	private String workerName;
	
	public Worker(int workerNo, String workerName) {
		super();
		this.workerNo = workerNo;
		this.workerName = workerName;
	}

	public void run() {
		String prefix = workerNo + " " + workerName + " ";
		System.out.println(prefix + "requirement");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(prefix + "design");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(prefix + "code");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(prefix + "test");
	}
	
}
