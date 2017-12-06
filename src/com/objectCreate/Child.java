package com.objectCreate;

public class Child extends Parent {
	{
		System.out.println("执行Child的普通代码块...");
	}
	static{
		System.out.println("执行Child的静态代码块...");
	}
	public Child() {
		super(222);
		System.out.println("a= "+a);
		System.out.println("执行Child的构造方法...");
	}
	static{
		System.out.println("执行Child的静态代码块222...");
	}
	{
		System.out.println("执行Child的普通代码块222...");
	}
	
}
