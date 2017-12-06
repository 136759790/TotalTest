package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test4 {
	public static void main(String[] args) {
		File f=new File("d://测试接口连接.txt");
		File f2=new File("d://测试接口连接2.txt");
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			writer =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2)));
			String result=null;
			while ((result=reader.readLine())!=null) {
				writer.write(result+System.getProperty("line.separator"));
				writer.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
