package com.ioTest;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw=new FileWriter("demo.txt");
		
		//构造函数汇总加入true，可以实现对文件进行续写
//		FileWriter fw=new FileWriter("demo.txt",true);

//		调用Writer对象中的writer(string)方法，写入数据，数据写入到临时存储缓冲区
		fw.write("abcde");
		
		//进行刷新，将数据直接写入到目的地中
		fw.flush();

		//关闭流，关闭资源，在关闭前会先调用flush刷新缓冲中的数据搭配目的的
		fw.close();
	}
}
