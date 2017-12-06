package com.threadTest;

import java.util.concurrent.CountDownLatch;

public class Thread1 implements Runnable{
	private String name;
	private Integer count;
	CountDownLatch latch;
	

	public Thread1(String name, Integer count, CountDownLatch latch) {
		super();
		this.name = name;
		this.count = count;
		this.latch = latch;
	}


	@Override
	public void run() {
		Object o=new Object();
		synchronized (o) {
			
			for (int i = 0; i < 10; i++) {
				latch.countDown();
				System.out.println("当前线程为："+count--);
			}
			System.out.println("Thread1的线程是否拥有锁："+Thread.holdsLock(o));
		}
	}

}
