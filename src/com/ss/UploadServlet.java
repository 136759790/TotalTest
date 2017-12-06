package com.ss;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Part part= req.getPart("img");
		InputStream in= part.getInputStream();
		int size= in.available();
		byte[] buf=new byte[size];
		in.read(buf);
		
		String name=req.getParameter("img_name");
		File target=new File("E://"+name);
		FileOutputStream out=new FileOutputStream(target);
		out.write(buf);
		out.flush();
		in.close();
		out.close();
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
