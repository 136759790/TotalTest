package com.ioTest;

import java.io.File;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) {
		createFile();
	}
	public static void createFile(){
		File f=new File("E:/表忠心.docx");
		try {
			//当且仅当不存在此抽象路径名指定名称的文件时，不可分的创建一个新的空文件
			f.createNewFile();
			System.out.println("该分区大小： "+f.getTotalSpace()/(1024*1024*1024)+ " G");
			//创建此抽象路径指定的目录
			f.mkdirs();
			System.out.println("文件名 "+f.getName());
			System.out.println("文件父目录字符串 "+f.getParent());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
