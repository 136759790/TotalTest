package com.servletTest;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	/*	String name=req.getParameter("name");
		String age=req.getParameter("age");
		System.out.println(name);
		System.out.println(age);*/
		String [] names=req.getParameterValues("name");
		for (String name : names) {
			System.out.println(name);
		}
		req.getRequestDispatcher("/second").forward(req, resp);
		User user=new User();
		user.setAge(12);
		user.setName("if");
		user.setPhone("123456789");
		req.getSession().setAttribute("user", user);
		User u1=(User) req.getSession().getAttribute("user");
		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.getPhone());
		
	
	}
}
