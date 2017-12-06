package com.proxyTest;

public class Test {
	public static void main(String[] args) {
		UserManager userManager=(UserManager) new CGLibProxy()
							.createProxyObject(new UserManagerImpl());
		System.out.println("----CGLibProxy------");
		userManager.addUser("tom", "root");
		System.out.println("----JDKProxy------");
		JdkProxy jdkProxy=new JdkProxy();
		
		UserManager userManagerJDK= (UserManager) jdkProxy.newProxy(new UserManagerImpl());
		userManagerJDK.addUser("tom", "root");
	}
}
