package com.ioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCount {
	public static void main(String[] args) {
		int count=0; //ͳ���ļ��ֽڵĳ���
		FileInputStream streamReader=null; //�ļ�������
		
		try {
			streamReader=new FileInputStream(new File("E:/������.docx"));
			while(streamReader.read()!=-1){//��ȡ�ļ��ֽڣ�������ָ�뵽��һ���ֽ�
				count++;
			}
			System.out.println("--�����ǣ�"+count+" �ֽ�");
		} catch (final IOException e) {
			e.printStackTrace();
		}finally{
			try {
				streamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
