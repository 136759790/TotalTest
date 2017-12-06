package com.gongxiangshuju.unshare;

import com.gongxiangshuju.MyData;

public class TestOne {
	public static void main(String[] args) {
		MyData data=new MyData();
		Runnable add=new AddRunnbale(data);
		Runnable dec=new DecRunnable(data);
		for (int i = 0; i < 2; i++) {
			new Thread(add).start();
			new Thread(dec).start();
		}
	}
}
