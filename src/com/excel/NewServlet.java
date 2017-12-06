package com.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;       

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class NewServlet extends HttpServlet{
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Connection", "close");
		resp.setHeader("Content-Type", "application/vnd.ms-excel;charset=UTF-8");
		String filename=System.currentTimeMillis()+"ѧ����Ϣ.xls";
		filename=encodeFileName(req,filename);
		resp.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		OutputStream out=null;
		
		try {
			String[] headers={"����","����"};
			List<Student> dataset=new ArrayList<Student>();
			dataset.add(new Student("��������","20"));
			dataset.add(new Student("����","24"));
			dataset.add(new Student("��������","2223330"));
			
			ExcelUtilTest<Student> eu=new ExcelUtilTest<Student>();
			HSSFWorkbook workbook=eu.exportExcel("��Ʊ����", headers, dataset);
			
			out=resp.getOutputStream();
			workbook.write(out);
					
		} finally{
			if(out!=null){
				out.close();
			}
		}
	}

	private String encodeFileName(HttpServletRequest req,
			String fileName) throws UnsupportedEncodingException {
		String agent=req.getHeader("USER-AGENT");
		if(null!=agent&&-1!=agent.indexOf("MSIE")){
			return URLEncoder.encode(fileName,"UTF-8");
		}else if(null != agent && -1 != agent.indexOf("Mozilla")){
			 return "=?UTF-8?B?"+ (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
		}else{
			return fileName;
		}
	}
	
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
}
