package com.example.concurrent.Thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		// 创建线程池
		// @param corePoolSize the number of threads to keep in the pool, even
		// if they are idle, unless {@code allowCoreThreadTimeOut} is set
		//
		// @param maximumPoolSize the maximum number of threads to allow in the
		// pool
		//
		// @param keepAliveTime when the number of threads is greater than
		// the core, this is the maximum time that excess idle threads
		// will wait for new tasks before terminating.
		//
		// @param unit the time unit for the {@code keepAliveTime} argument
		//
		// @param workQueue the queue to use for holding tasks before they are
		// executed. This queue will hold only the {@code Runnable}
		// tasks submitted by the {@code execute} method.
		
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 6, 1000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(2));
		for(int i=0; i<8; i++) {
			Worker work = new Worker(i, "worker"+i);
			threadPool.execute(work);
			System.out.println("缓存队列中的任务数 = " + threadPool.getQueue().size());
			System.out.println("taskCount = " + threadPool.getTaskCount());
			System.out.println("poolSize = " + threadPool.getPoolSize());
			System.out.println("");
		}
		threadPool.shutdown();
	}

}
