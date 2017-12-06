package com.th.c1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Test3 {
	public static void main(String[] args) throws InterruptedException {
		Integer count=2000;
		CountDownLatch latch=new CountDownLatch(2000);
		System.out.println(count);
		TestThread t=new TestThread(count,latch);
		Thread t1=new Thread(t,"线程1");
		Thread t2=new Thread(t,"线程2");
		t1.start();
		t2.start();
		latch.await();
		Map map=new HashMap();
		map.put("name", "qxq");
		map.put("age", "zat");
		map.put("add", "efs");
		Set keys=map.keySet();
/*		for (Object key : keys) {
			System.out.println(key);
		}*/
		
		   Iterator<String> it = keys.iterator();//有了Set集合，就可以获取其迭代器。
           
	        while(it.hasNext()){
                String key = it.next();
                String value = (String) map.get(key);//有了键可以通过map集合的get方法获取其对应的值。
                        
                System.out.println("key: "+key+"-->value: "+value);//获得key和value值
                
                }
	        Collection<String> collection = map.values();//返回值是个值的Collection集合
	        System.out.println(collection);
	}
}
