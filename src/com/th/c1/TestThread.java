package com.th.c1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class  TestThread implements Runnable{
	
	private Integer count;
	private CountDownLatch latch;
	
	public TestThread(Integer count, CountDownLatch latch) {
		super();
		this.count = count;
		this.latch = latch;
	}



	private Lock lock=new ReentrantLock();
	
	public TestThread(Integer count) {
		super();
		this.count = count;
	}



	@Override
	public  void run() {
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					lock.lock();
					latch.countDown();
					System.out.println(Thread.currentThread().getName()+"¼õÒ»----------->"+(--count));
				} finally {
					lock.unlock();
				}
//				synchronized (this) {
//					System.out.println(Thread.currentThread().getName()+"¼õÒ»----------->"+(--count));
//				}
			}
	}

}
