package com.ioTest;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
	public static void main(String[] args) throws IOException {
		demo_write();
	}
	public static void demo_write() throws IOException{
		//创建字节输出流对象，用于操作文件
		FileOutputStream fos=new FileOutputStream("bytedemo.txt");
		
		//写数据，直接写入了目的地中
		fos.write("abcdefg".getBytes());
		
		//关闭资源工作要完成
		fos.close();
	}
}
