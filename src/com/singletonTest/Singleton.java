package com.singletonTest;

//饿汉式：当类加载的时候就进行了实例化，速度比较快
public class Singleton {
	private static Singleton instance=new Singleton();
	//内部调用，构造方法私有，保证外界无法实例化类
	private Singleton() {}
	//提供单例获取的方式
	public static Singleton getInstance() {
		return instance;
	}
}
