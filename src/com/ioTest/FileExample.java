package com.ioTest;

import java.io.File;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) {
		createFile();
	}
	public static void createFile(){
		File f=new File("E:/������.docx");
		try {
			//���ҽ��������ڴ˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵĴ���һ���µĿ��ļ�
			f.createNewFile();
			System.out.println("�÷�����С�� "+f.getTotalSpace()/(1024*1024*1024)+ " G");
			//�����˳���·��ָ����Ŀ¼
			f.mkdirs();
			System.out.println("�ļ��� "+f.getName());
			System.out.println("�ļ���Ŀ¼�ַ��� "+f.getParent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
