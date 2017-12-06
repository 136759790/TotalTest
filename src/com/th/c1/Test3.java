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
		Thread t1=new Thread(t,"�߳�1");
		Thread t2=new Thread(t,"�߳�2");
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
		
		   Iterator<String> it = keys.iterator();//����Set���ϣ��Ϳ��Ի�ȡ���������
           
	        while(it.hasNext()){
                String key = it.next();
                String value = (String) map.get(key);//���˼�����ͨ��map���ϵ�get������ȡ���Ӧ��ֵ��
                        
                System.out.println("key: "+key+"-->value: "+value);//���key��valueֵ
                
                }
	        Collection<String> collection = map.values();//����ֵ�Ǹ�ֵ��Collection����
	        System.out.println(collection);
	}
}
