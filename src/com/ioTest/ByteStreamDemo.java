package com.ioTest;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
	public static void main(String[] args) throws IOException {
		demo_write();
	}
	public static void demo_write() throws IOException{
		//�����ֽ�������������ڲ����ļ�
		FileOutputStream fos=new FileOutputStream("bytedemo.txt");
		
		//д���ݣ�ֱ��д����Ŀ�ĵ���
		fos.write("abcdefg".getBytes());
		
		//�ر���Դ����Ҫ���
		fos.close();
	}
}
