package com.threadTest;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Integer count = 10;
		Object o=new Object();
		CountDownLatch latch=new CountDownLatch(5);
		Thread1 thread1=new Thread1("t1", count, latch);
		Thread  t1=new Thread(thread1);
		t1.start();
	
		latch.await();

//		t1.join();
		System.out.println("main的线程是否拥有锁："+Thread.holdsLock(o));
		/*System.out.println("主线程---->");*/
	}
}
