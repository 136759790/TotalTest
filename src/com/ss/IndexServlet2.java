package com.ss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String name=req.getParameter("name");
		
		System.out.println(name);
		
		System.out.println(111);
		resp.sendRedirect("index.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(222);
		super.doPost(req, resp);
	}
	public static void main(String[] args) {
		System.out.println(EnumColor.MALE.getGender());
		System.out.println((EnumColor.MALE.getDesc()));
		System.out.println(Constants.MALE);
	}
	
}
