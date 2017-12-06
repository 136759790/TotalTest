package com.iterator;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("qxq");
		list.add("wsx");
		list.add("fdr");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
