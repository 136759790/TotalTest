package com.threadTest;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public final class ThreadPool {
	//�̳߳���Ĭ���̵߳ĸ���Ϊ5
	private static int worker_num=5;
	//�����߳�
	private WorkThread[] workThreads;
	//δ���������
	private static volatile int finished_task=0;
	//������У���Ϊһ�����壬list�̲߳���ȫ
	private List<Runnable> taskQuene=new LinkedList<Runnable>();
	//�̳߳�
	private static ThreadPool threadPool;
	
	//��������Ĭ���̸߳������̳߳�
	private ThreadPool(){
		this(5);
	}
	//�����̳߳أ�worker_numΪ�̳߳��й����̵߳ĸ���
	private ThreadPool(int worker_num){
		ThreadPool.worker_num=worker_num;
		workThreads=new WorkThread[worker_num];
		for (int i = 0; i < worker_num; i++) {
			workThreads[i]=new WorkThread();
//			�����̳߳��е��̣߳�
			workThreads[i].start();
		}
	}
//	��̬ģʽ�����һ��Ĭ���̸߳������̳߳�
	public static ThreadPool getThreadPool(){
		return getThreadPool(ThreadPool.worker_num);
	}
	//��̬ģʽ�����һ��ָ���̸߳������̳߳أ�worker_num(>0)Ϊ�̳߳��еĹ����̵߳ĸ���
//	worker_num<=0����Ĭ�ϵĹ����̸߳�����
	  static ThreadPool getThreadPool(int worker_num1) {
		 if(worker_num1<=0){
			 worker_num1=ThreadPool.worker_num;
		 }
		 if(threadPool==null){
			 threadPool=new ThreadPool(worker_num1);
		 }
		 return threadPool;
	}
	 
//	 ִ��������ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ع���������
	 public void execute(Runnable task){
		 synchronized (taskQuene) {
			taskQuene.add(task);
			taskQuene.notify();
		}
	 }
	 //����ִ��������ʵֻ�ǰ��������������У�ʲôʱ��ִ�����̳߳ؾ���
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
	 //�����̳߳أ��÷�����֤������������ɵ�����²����������̣߳�����ȴ�������ɲ�����
	 public void destroy(){
		 //�����������ûִ����ɣ�����˯��
		 while(!taskQuene.isEmpty()){
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
//		 �����߳�ֹͣ����������Ϊnull;
		for (int i = 0; i < worker_num; i++) {
			workThreads[i].stop();
			workThreads[i]=null;
		}
		threadPool=null;
		//����������
		taskQuene.clear();
	 }
//	 ..���ع����̵߳ĸ���
	 public int getWorkThreadNumber(){
		 return worker_num;
	 }
	 //�������������ĸ�����������������ֻ����������е�������������ܸ�����û��ʵ��ִ�����
	 public int getFinishedTasknumber(){
		 return finished_task;
	 }
	 //����������еĳ��ȣ�����û������������
	 public int getWaitTasknumber(){
		 return taskQuene.size();
	 }
	 //����toString()�����������̳߳���Ϣ�������̸߳�����������������
	 public String toString() {
		 return "WorkThread number: "+worker_num+"  finished task number: "
				 +finished_task+" wait task number: "+getWaitTasknumber();
	 }
	 
	 //�ڲ��࣬�����߳�
	class WorkThread extends Thread{

		//�ù����߳� �ǹ���Ч�����ڽ����ù����߳�
		private boolean isRunning=true;
		
		@Override
		public void run() {
			Runnable r=null;
			//���߳���Ч����Ȼ����run���������߳̾�û����
			while(isRunning){
				synchronized (taskQuene) {
					//����Ϊ��
					while(isRunning&&taskQuene.isEmpty()){
						try {
							taskQuene.wait(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(!taskQuene.isEmpty()){
						//ȡ������
						r=taskQuene.remove(0);
					}
					if(r!=null){
						//ִ������
						r.run();
					}
					finished_task++;
					r=null;
				}
			}
		}
	}
}
