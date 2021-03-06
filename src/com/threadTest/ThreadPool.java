package com.threadTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public final class ThreadPool {
	//线程池中默认线程的个数为5
	private static int worker_num=5;
	//工作线程
	private WorkThread[] workThreads;
	//未处理的任务
	private static volatile int finished_task=0;
	//任务队列，作为一个缓冲，list线程不安全
	private List<Runnable> taskQuene=new LinkedList<Runnable>();
	//线程池
	private static ThreadPool threadPool;
	
	//创建具有默认线程个数的线程池
	private ThreadPool(){
		this(5);
	}
	//创建线程池，worker_num为线程池中工作线程的个数
	private ThreadPool(int worker_num){
		ThreadPool.worker_num=worker_num;
		workThreads=new WorkThread[worker_num];
		for (int i = 0; i < worker_num; i++) {
			workThreads[i]=new WorkThread();
//			开启线程池中的线程；
			workThreads[i].start();
		}
	}
//	单态模式，获得一个默认线程个数的线程池
	public static ThreadPool getThreadPool(){
		return getThreadPool(ThreadPool.worker_num);
	}
	//单态模式，获得一个指定线程个数的线程池，worker_num(>0)为线程池中的工作线程的个数
//	worker_num<=0创建默认的工作线程个数；
	  static ThreadPool getThreadPool(int worker_num1) {
		 if(worker_num1<=0){
			 worker_num1=ThreadPool.worker_num;
		 }
		 if(threadPool==null){
			 threadPool=new ThreadPool(worker_num1);
		 }
		 return threadPool;
	}
	 
//	 执行任务，其实只是把任务加入任务队列，什么时候执行有线程池管理器决定
	 public void execute(Runnable task){
		 synchronized (taskQuene) {
			taskQuene.add(task);
			taskQuene.notify();
		}
	 }
	 //批量执行任务，其实只是把任务加入任务队列，什么时候执行有线程池决定
	 public void execute(Runnable[] task){
		 synchronized (taskQuene) {
			for (Runnable t : task) {
				taskQuene.add(t);
			}
			taskQuene.notify();
		}
	 }
	 public void execute(List<Runnable> task){
		 synchronized (taskQuene) {
			for (Runnable t : task) {
				taskQuene.add(t);
			}
			taskQuene.notify(); 
		}
	 }
	 //销毁线程池，该方法保证在所有任务完成的情况下才销毁所有线程，否则等待任务完成才销毁
	 public void destroy(){
		 //如果还有任务没执行完成，就先睡会
		 while(!taskQuene.isEmpty()){
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
//		 工作线程停止工作，且置为null;
		for (int i = 0; i < worker_num; i++) {
			workThreads[i].stop();
			workThreads[i]=null;
		}
		threadPool=null;
		//清空任务队列
		taskQuene.clear();
	 }
//	 ..返回工作线程的个数
	 public int getWorkThreadNumber(){
		 return worker_num;
	 }
	 //返回已完成任务的个数，这里的已完成是只出了任务队列的任务个数，可能该任务并没有实际执行完成
	 public int getFinishedTasknumber(){
		 return finished_task;
	 }
	 //返回任务队列的长度，即还没处理的任务个数
	 public int getWaitTasknumber(){
		 return taskQuene.size();
	 }
	 //覆盖toString()方法，返回线程池信息，工作线程个数和已完成任务个数
	 public String toString() {
		 return "WorkThread number: "+worker_num+"  finished task number: "
				 +finished_task+" wait task number: "+getWaitTasknumber();
	 }
	 
	 //内部类，工作线程
	class WorkThread extends Thread{

		//该工作线程 是够有效，用于结束该工作线程
		private boolean isRunning=true;
		
		@Override
		public void run() {
			Runnable r=null;
			//该线程无效则自然结束run方法，该线程就没用了
			while(isRunning){
				synchronized (taskQuene) {
					//队列为空
					while(isRunning&&taskQuene.isEmpty()){
						try {
							taskQuene.wait(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(!taskQuene.isEmpty()){
						//取出任务
						r=taskQuene.remove(0);
					}
					if(r!=null){
						//执行任务
						r.run();
					}
					finished_task++;
					r=null;
				}
			}
		}
	}
}
