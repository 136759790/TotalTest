package com.ioTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw=new FileWriter("buf.txt");
		
		BufferedWriter bufw=new BufferedWriter(fw);
		for (int x = 0; x < 5; x++) {
			//ʹ�û�������д�뷽������������д�뻺����
			bufw.write("abcdef  "+x);
			//д�����ݻ��з�����newLine()
			bufw.newLine();
		}
		
		//ʹ�û�������ˢ�·�������������Ŀ�ĵ�
		bufw.flush();
		
		//�رջ���������ʵ�رյľ��Ǳ������������
		bufw.close();
		
		//��ȡ
		FileReader fr=new FileReader("buf.txt");
		//�����ַ���ȡ���Ļ������
		BufferedReader bufr=new BufferedReader(fr);
		
		String line=null;
		
		//��ȡһ��
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		
		fr.close();
		
	}
}
