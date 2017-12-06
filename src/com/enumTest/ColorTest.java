package com.enumTest;

public enum ColorTest {
	YELLOW("»Æ",1),
	RED("ºì",2),
	BLUE("À¶",3);
	
	private String name;
	private Integer code;
	private ColorTest(String name, Integer code) {
		this.name = name;
		this.code = code;
	}
	
	public static void main(String[] args) {
		System.out.println(ColorTest.YELLOW.name);
		System.out.println(ColorTest.YELLOW.code);
	}
		
}
