package com.threadTest;

import java.lang.Thread.UncaughtExceptionHandler;

public class WitchCaughtThread {
	public static void main(String[] args) {
		Thread thread=new Thread(new Task());
		thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
	
	static class ExceptionHandler implements UncaughtExceptionHandler{

		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("==Exception"+e.getMessage());
		}
	}
	
	 static class Task implements Runnable{

		@Override
		public void run() {
			System.out.println(3/2);
			System.out.println(3/0);
			System.out.println(3/1);
		}
	}
}
