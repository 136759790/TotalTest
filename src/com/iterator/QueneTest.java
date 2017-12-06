package com.iterator;
import java.util.Queue; 
import java.util.concurrent.LinkedBlockingQueue;

public class QueneTest {
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedBlockingQueue();
		for (int i = 0; i < 5; i++) {
			q.offer(i);
		}
		//集合方式遍历，元素不会被移除
		System.out.println("---1----");
		for (Integer integer : q) {
			System.out.println("集合方式遍历"+integer);
		}
		System.out.println("---2----");
		//队列方式遍历，元素逐个删除
		while(q.peek()!=null){
			System.out.println("队列方式遍历： "+q.poll());
		}
	}
}
