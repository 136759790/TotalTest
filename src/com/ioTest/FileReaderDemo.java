package com.ioTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("demo.txt");
		
		//��һ�ֶ�ȡ��ʽ��ʹ��read()������ȡ�����ַ�������ĩβ����-1
	/*	int ch=0;
		while((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}*/
		
		//�ڶ��ֶ�ȡ��ʽ��ʹ��read(char[])��ȡ����ַ�
		//�ȴ����ַ�����
		char[] buf=new char[3];
		int len=0;
		while((len=fr.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		
		fr.close();
	}
}
