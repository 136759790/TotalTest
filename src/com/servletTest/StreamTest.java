package com.servletTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamTest {
	public static void main(String[] args) {
		
		File file=new File("");
		InputStream in=null;
		try{
			System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
			in=new FileInputStream(file);
			int tempbyte;
			while((tempbyte=in.read())!=-1){
				System.out.println(tempbyte);
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace();
			return;
		}
	}
}
