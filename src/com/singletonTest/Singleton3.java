package com.singletonTest;

public enum Singleton3 {
	INSTANCE;
	public void run(){
		
	}
	//通过枚举类得到类的对象的方法
	public static void main(String[] args) {
		Singleton3.INSTANCE.run();
	}
}
