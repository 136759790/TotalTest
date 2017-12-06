package com.iterator;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> tree=new TreeSet<Integer>();
		tree.add(897);
		tree.add(1);
		tree.add(45);
		tree.add(100);
		System.out.println("自然排序："+tree);
		
		TreeSet<Integer> tree1=new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		tree1.add(897);
		tree1.add(1);
		tree1.add(45);
		tree1.add(100);
		System.out.println("倒序排列："+tree1);
		
	}
}
