package com.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//jdk代理
public class JdkProxy implements InvocationHandler {
	//需要代理的目对象
	private Object targetObject;

	public Object newProxy(Object targetObject){
		//将目标对象传入进行代理
		this.targetObject=targetObject;
		//返回代理对象
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), 
				targetObject.getClass().getInterfaces(), this);
	} 
	
	//invoke()方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		checkPopedom();//一般我们进行逻辑处理的函数比如这个地方是模拟检查权限
		Object ret=null;//设置方法的返回值
		ret=method.invoke(targetObject, args);//调用invoke方法，ret存储该方法的返回值
		return ret;
	}

	//模拟检查权限的例子
	private void checkPopedom() {
		System.out.println(".:检查权限 checkPopedom()! ");
	}

}
