package com.objectCreate;

public class Parent extends Grandpa {
	protected int a=111;
	{
		System.out.println("执行Parent的普通块...");
	}
	static{
		System.out.println("执行Parent的静态块...");
	}
	public Parent() {
		System.out.println("执行Parent的构造方法...");
	}
	public Parent(int a) {
		this.a = a;
		System.out.println("执行Parent的构造方法：InitParent(int a)...");
	}
	static{
		System.out.println("执行Parent的静态块222...");
	}
	{
		System.out.println("执行Parent的普通块222...");
	}
	
}
