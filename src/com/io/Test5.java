package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test5 {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		Integer location=null;
		try {
			bis = new BufferedInputStream(
					new FileInputStream(new File("E:/±íÖÒÐÄ.docx")));
			bos=new BufferedOutputStream(
					new FileOutputStream(new File("E:/¸´ÖÆ.docx")));
			while((location=bis.read())!=-1){
				bos.write(location);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				bis.close();
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
