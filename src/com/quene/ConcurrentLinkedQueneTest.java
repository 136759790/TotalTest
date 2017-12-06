package com.quene;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueneTest {
	private static ConcurrentLinkedQueue<Integer> quene=new 
			ConcurrentLinkedQueue<Integer>();
	
	private static int count=2;
	
	private static CountDownLatch latch=new CountDownLatch(count);
	public static void main(String[] args) throws InterruptedException{
		
		Long timeStart=System.currentTimeMillis();
		ExecutorService es=Executors.newFixedThreadPool(4);
		
		ConcurrentLinkedQueneTest.offer();
		for (int i = 0; i < count ; i++) {
			es.submit(new Poll());
		}
		latch.await();
		System.out.println("cost time "+(System.currentTimeMillis()-timeStart)+" ms");
		es.shutdown();
	}
	
	//生产
	private static void offer() {
		for (int i = 0; i < 1000 ; i++) {
			quene.offer(i);
		}
	}
	//消费
	static class Poll implements Runnable{

		@Override
		public void run() {
			while(!quene.isEmpty()){
				System.out.println(quene.poll());
			}
			latch.countDown();
		}
		
	}
	
}
