package com.ioTest;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw=new FileWriter("demo.txt");
		
		//���캯�����ܼ���true������ʵ�ֶ��ļ�������д
//		FileWriter fw=new FileWriter("demo.txt",true);

//		����Writer�����е�writer(string)������д�����ݣ�����д�뵽��ʱ�洢������
		fw.write("abcde");
		
		//����ˢ�£�������ֱ��д�뵽Ŀ�ĵ���
		fw.flush();

		//�ر������ر���Դ���ڹر�ǰ���ȵ���flushˢ�»����е����ݴ���Ŀ�ĵ�
		fw.close();
	}
}
