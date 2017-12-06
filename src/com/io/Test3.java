package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

public class Test3 {
	public static void main(String[] args) {
		File f=new File("d://测试接口连接.txt");
		File f2=new File("d://测试接口连接2.txt");
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		int location=0;
		try {
			bis =new BufferedInputStream(new FileInputStream(f),8);
			bos=new BufferedOutputStream(new FileOutputStream(f2),8);
			while ((location=bis.read()) !=-1) {
				bos.write(location);
				bos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
