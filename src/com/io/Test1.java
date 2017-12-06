package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) {
		File f=new File("E:/±íÖÒÐÄ.docx");
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(f);
			int size= fis.available();
			byte[] array=new byte[size];
			fis.read(array);
			System.out.println(new String(array));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
