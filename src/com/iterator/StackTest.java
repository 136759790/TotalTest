package com.iterator;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack s=new Stack();
		for (int i = 0; i < 5; i++) {
			s.push(i);
		}
		for (Object in : s) {
			System.out.println("集合遍历的结果是："+in);
		}
//		栈弹出遍历方式
		while(!s.empty()){
			System.out.println("栈弹出遍历的方式"+s.pop());
		}
	}
}
