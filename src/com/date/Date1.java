package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {
	public static void main(String[] args) throws ParseException {
		
		String str="20171111111111";
		Date d1=new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
		System.out.println(d1);
		String t1=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(d1);
		System.out.println(t1);
	}
	
}
