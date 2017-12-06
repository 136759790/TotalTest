package com.ss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		System.out.println(name + age);
		System.out.println(111);
		if(name!=null && !"".equals(name)){
			req.getSession().setAttribute("name", name);
		}
		System.out.println(req.getSession().getAttribute("name"));
		req.getRequestDispatcher("/index2").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(222);
		super.doPost(req, resp);
	}
	
}
