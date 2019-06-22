package com.example.concurrent.Thread.state;

import java.util.List;

public class Consumer extends Thread {

	private String name;
	private List<String> list;
	private Object object;

	public Consumer(String name, List<String> list, Object object) {
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
			// WAITING
			synchronized (object) {
				object.wait();
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		while (true) {
			// BLOCKED
			synchronized (list) {
				// RUNNABLE
				printState();
				deleteProducter();
				// TIMED_WAITING
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 */
	private void deleteProducter() {
		if (null != list && !list.isEmpty() && list.size() >= 2) {
			// delete element
			System.out.println(this.name + " delete: " + list.remove(0) + " " + list.remove(1));
			list.notifyAll();
		} else {
			try {
				list.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 打印线程状态
	 */
	private void printState() {
		System.out.println(this.name + " state: " + this.getState().toString());
	}
}
