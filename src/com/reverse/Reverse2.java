package com.reverse;

public class Reverse2 {
	public static void main(String[] args) {
		
		String str="123456";
		StringBuilder sb=new StringBuilder();
		for (int i = str.length()-1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		System.out.println(sb);
	}
	
}
