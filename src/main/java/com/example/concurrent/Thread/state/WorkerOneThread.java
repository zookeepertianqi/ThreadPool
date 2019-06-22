package com.example.concurrent.Thread.state;

public class WorkerOneThread extends Thread {

	private String name;
	
	public WorkerOneThread(String name) {
		super();
		this.name = name;
		this.setName(name);
		printState();
	}


	@Override
	public void run() {
		while(true) {
			System.out.println(name + " is running");
			System.out.println("programming");
			printState();
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 打印线程状态
	 */
	private void printState() {
		System.out.println("state:"+ this.getState().toString());
	}
}
