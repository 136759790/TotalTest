package com.iterator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String,String>();
		map.put("name", "qxq");
		map.put("age", "23");
		map.put("address", "北京");
		for (Map.Entry entry : map.entrySet()) {
			System.out.println("Key: "+entry.getKey()+"  Value: "+entry.getValue());
		}
		Set keys=map.keySet();
		for (Object key : keys) {
			System.out.println(key);
		}
		Collection collections=map.values();
		for (Object collection : collections) {
			System.out.println(collection);
		}
	}
}
