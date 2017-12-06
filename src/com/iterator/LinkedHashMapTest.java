package com.iterator;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		Map<String, String> map=new LinkedHashMap();
		map.put("qc", "ed");
		map.put("ed", "ty");
		map.put("ff", "ybd");
		map.put("rg", "ertre");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key: "+entry.getKey());
			System.out.println("Value: "+entry.getValue());
		}
		
		
	}
}
