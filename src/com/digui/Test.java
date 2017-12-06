package com.digui;

/**
 * 1 1 2 3 5 8 13
 * @author Administrator
 *
 */

public class Test {
	public static void main(String[] args) {
		System.out.println(fbnq(6));
	}
	public static int fbnq(int index){
		if(index==0||index==1){
			return 1;
		}else{
			return fbnq(index-2)+fbnq(index-1);
		}
	}
}
