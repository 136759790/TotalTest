package com.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set set=new HashSet();
		set.add("q");
		set.add("qxq");
		set.add("cyc");
		for (Object s : set) {
			System.out.println(s);
		}
		Iterator it=set.iterator();
		while(it.hasNext()){
			String str=(String) it.next();
			System.out.println(str);
		}
	}

}
