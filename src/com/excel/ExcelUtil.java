package com.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil {
	public static String NO_DEFINE="no_define";//未定义的字段
	public static String DEFAULT_DATE_PATTERN="yyyy年MM月dd日";//默认日期格式
	public static int DEFAULT_COLUMN_WIDTH=17;
	
	/**
	 * 导出Excel97(.xsl)格式，少量数据
	 * @param title标题行
	 * @param headMap属性-列名
	 * @param jsonArray数据集
	 * @param datePattern日期格式，null则默认日期格式
	 * @param colWidth列宽，默认至少17个字节
	 * @param out 输出流
	 */
	
	 public static void exportExcel(String title, Map<String, String> headMap,
			JSONArray jsonArray, String datePattern, int colWidth, OutputStream out){
		 if(datePattern==null){
			 datePattern=DEFAULT_DATE_PATTERN;
		 }
		 //声明一个工作簿
		 HSSFWorkbook workbook=new HSSFWorkbook();
		 workbook.createInformationProperties();
		 workbook.getDocumentSummaryInformation().setCompany("***公司");
     
		 SummaryInformation si=workbook.getSummaryInformation();
		 si.setAuthor("qxq");//添加xls文件作者信息
		 si.setApplicationName("导出程序");//添加xls文件创建程序信息
		 si.setLastAuthor("最后保存者信息");//添加xls文件最后保存者信息
		 si.setComments("qxq is a programmer");//添加xls文件作者信息
		 si.setTitle("POI导出Excel");//添加xls文件标题信息
		 si.setSubject("增加文件主体信息");//添加文件主体信息
		 si.setCreateDateTime(new Date());
		 
		 //表头样式
		 HSSFCellStyle titleStyle=workbook.createCellStyle();
		 titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 HSSFFont titleFont=workbook.createFont();
		 titleFont.setFontHeightInPoints((short)20);
		 titleFont.setBoldweight((short)700);
		 titleStyle.setFont(titleFont);
		 
		 //列头样式
		 HSSFCellStyle headerStyle=workbook.createCellStyle();
		 headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		 headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 HSSFFont headerFont=workbook.createFont();
		 headerFont.setFontHeightInPoints((short)12);
		 headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 headerStyle.setFont(headerFont);
		 
		 //单元格样式
		 HSSFCellStyle cellStyle=workbook.createCellStyle();
		 cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		 cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		 HSSFFont cellFont=workbook.createFont();
		 cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		 cellStyle.setFont(cellFont);
		 
		 //生成一个带标题的表格
		 HSSFSheet sheet=workbook.createSheet();
		 //声明一个画图的顶级管理器
		 HSSFPatriarch  patriarch=sheet.createDrawingPatriarch();
		 //定义注释的大小和位置
		 HSSFComment comment=patriarch.createComment(
				 new HSSFClientAnchor(0,0,0,0,(short)4,2,(short)6,5));
		 //设置注释内容
		 comment.setString(new HSSFRichTextString("可以在POI添加注释！！"));
		 //设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到内容
		 comment.setAuthor("qxq");
		 //设置列宽
		 int minBytes=colWidth<DEFAULT_COLUMN_WIDTH?DEFAULT_COLUMN_WIDTH:colWidth;
		 int [] arrColWidth=new int[headMap.size()];
		 //产生表格标题行，以及设置列宽
		 String[] properties=new String[headMap.size()];
		 String[] headers=new String[headMap.size()];
		 int ii=0;
		 for (Iterator<String> iter = headMap.keySet().iterator(); iter.hasNext();) {
			
			String filedName =  iter.next();
			
			properties[ii]=filedName;
			headers[ii]=filedName;
			
			int bytes=filedName.getBytes().length;
			
			arrColWidth[ii]=bytes<minBytes?minBytes:bytes;
			sheet.setColumnWidth(ii, arrColWidth[ii]*256);
			ii++;
		}
		 
		 //遍历集合数据，产生数据行
		 int rowIndex=0;
		 for (Object obj :jsonArray) {
			if(rowIndex==65535||rowIndex==0){
				if(rowIndex!=0){
					//如果数据超过了，则在第二页显示
					sheet=workbook.createSheet();
				}
				
				//表头rowIndex=0;
				HSSFRow titleRow=sheet.createRow(0);
				titleRow.createCell(0).setCellValue(title);
				titleRow.getCell(0).setCellStyle(titleStyle);
				sheet.addMergedRegion(new CellRangeAddress(0,0,0,headMap.size()-1));
				
				//列头rowIndex=1
				HSSFRow headerRow=sheet.createRow(1);
				for (int i = 0; i < headers.length; i++) {
					headerRow.createCell(i).setCellValue(headers[i]);
					headerRow.getCell(i).setCellStyle(headerStyle);
				}
				
				//数据内容从rowIndex=2开始
				rowIndex=2;
			}
			JSONObject jo=new JSONObject();
//					.toJSON(obj);
			HSSFRow datarRow=sheet.createRow(rowIndex);
			for (int i = 0; i < properties.length; i++) {
				HSSFCell newCell=datarRow.createCell(i);
				
				Object o=jo.get(properties[i]);
				String cellValue="";
				if(o==null){
					cellValue="";
				}else if(o instanceof Date){
					cellValue=new SimpleDateFormat(datePattern).format(o);
				}else{
					cellValue=o.toString();
				}
				
				newCell.setCellValue(cellValue);
				newCell.setCellStyle(cellStyle);
			}
			rowIndex++;
		}
		 try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	
}
