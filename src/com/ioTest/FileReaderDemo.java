package com.ioTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("demo.txt");
		
		//第一种读取方式，使用read()方法读取单个字符，到达末尾返回-1
	/*	int ch=0;
		while((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}*/
		
		//第二种读取方式，使用read(char[])读取多个字符
		//先创建字符数组
		char[] buf=new char[3];
		int len=0;
		while((len=fr.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		
		fr.close();
	}
}
