package com.gongxiangshuju.unshare;

import com.gongxiangshuju.MyData;

public class AddRunnbale implements Runnable{
	MyData data;
	
	public AddRunnbale(MyData data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		data.add();
	}

}
