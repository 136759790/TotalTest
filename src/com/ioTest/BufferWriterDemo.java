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
			//使用缓冲区的写入方法，将数据先写入缓冲区
			bufw.write("abcdef  "+x);
			//写入内容换行方法：newLine()
			bufw.newLine();
		}
		
		//使用缓冲区的刷新方法将数据数到目的地
		bufw.flush();
		
		//关闭缓冲区，其实关闭的就是被缓冲的流对象
		bufw.close();
		
		//读取
		FileReader fr=new FileReader("buf.txt");
		//创建字符读取流的缓冲对象
		BufferedReader bufr=new BufferedReader(fr);
		
		String line=null;
		
		//读取一行
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		
		fr.close();
		
	}
}
