package com.example.concurrent.Thread.state;

import java.util.List;

/**
 * 
 * @author baofu.qi
 *
 */
public class Producer extends Thread {

	private String name;
	private List<String> list;
	private final int MAX_PRODUCTER_SIZE = 200;
	private Object object;
	
	public Producer(String name, List<String> list, Object object) {
		super();
		this.name = name;
		this.list = list;
		this.object = object;
		this.setName(name);
		// NEW
		printState();
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		int i = 0;
		while (true) {
			synchronized (list) {
				//RUNNABLE
				printState();
				if (list.size() > MAX_PRODUCTER_SIZE || i > MAX_PRODUCTER_SIZE) {
					try {
						System.out.println("list size:" + list.size());
						synchronized (object) {
							object.notify();
						}
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				addProducter(this.name + " " + i);
				i++;
				list.notifyAll();
			}
		}
	}
	
	/**
	 * 
	 * @param product
	 */
	private void addProducter(String product) {
		System.out.println("add: " + product);
		list.add(product);
	}
	
	/**
	 * 打印线程状态
	 */
	private void printState() {
		System.out.println(this.name + " state: "+ this.getState().toString());
	}
	
}
