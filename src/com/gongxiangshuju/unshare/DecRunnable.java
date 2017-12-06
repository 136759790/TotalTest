package com.gongxiangshuju.unshare;

import com.gongxiangshuju.MyData;

public class DecRunnable implements Runnable {
	MyData data;
	
	public DecRunnable(MyData data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		data.dec();
	}

}
