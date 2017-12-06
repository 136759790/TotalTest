package com.iterator;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap tree=new TreeMap();
		tree.put("2", "wjfg");
		tree.put("5", "tyui");
		tree.put("3", "etui");
		tree.put("1", "rrtty");
		System.out.println("TreeMap默认的排序顺序： "+tree);
	
		TreeMap tree2=new TreeMap(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		tree2.put("2", "wjfg");
		tree2.put("5", "tyui");
		tree2.put("3", "etui");
		tree2.put("1", "rrtty");
		
		System.out.println("TreeMap指定的排序顺序： "+tree2);
	
	}
}
