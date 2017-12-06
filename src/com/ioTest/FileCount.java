package com.ioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCount {
	public static void main(String[] args) {
		int count=0; //统计文件字节的长度
		FileInputStream streamReader=null; //文件输入流
		
		try {
			streamReader=new FileInputStream(new File("E:/表忠心.docx"));
			while(streamReader.read()!=-1){//读取文件字节，并递增指针到下一个字节
				count++;
			}
			System.out.println("--长度是："+count+" 字节");
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
