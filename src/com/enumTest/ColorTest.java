package com.enumTest;

public enum ColorTest {
	YELLOW("��",1),
	RED("��",2),
	BLUE("��",3);
	
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
