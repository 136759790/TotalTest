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
	public static String NO_DEFINE="no_define";//δ������ֶ�
	public static String DEFAULT_DATE_PATTERN="yyyy��MM��dd��";//Ĭ�����ڸ�ʽ
	public static int DEFAULT_COLUMN_WIDTH=17;
	
	/**
	 * ����Excel97(.xsl)��ʽ����������
	 * @param title������
	 * @param headMap����-����
	 * @param jsonArray���ݼ�
	 * @param datePattern���ڸ�ʽ��null��Ĭ�����ڸ�ʽ
	 * @param colWidth�п�Ĭ������17���ֽ�
	 * @param out �����
	 */
	
	 public static void exportExcel(String title, Map<String, String> headMap,
			JSONArray jsonArray, String datePattern, int colWidth, OutputStream out){
		 if(datePattern==null){
			 datePattern=DEFAULT_DATE_PATTERN;
		 }
		 //����һ��������
		 HSSFWorkbook workbook=new HSSFWorkbook();
		 workbook.createInformationProperties();
		 workbook.getDocumentSummaryInformation().setCompany("***��˾");
     
		 SummaryInformation si=workbook.getSummaryInformation();
		 si.setAuthor("qxq");//���xls�ļ�������Ϣ
		 si.setApplicationName("��������");//���xls�ļ�����������Ϣ
		 si.setLastAuthor("��󱣴�����Ϣ");//���xls�ļ���󱣴�����Ϣ
		 si.setComments("qxq is a programmer");//���xls�ļ�������Ϣ
		 si.setTitle("POI����Excel");//���xls�ļ�������Ϣ
		 si.setSubject("�����ļ�������Ϣ");//����ļ�������Ϣ
		 si.setCreateDateTime(new Date());
		 
		 //��ͷ��ʽ
		 HSSFCellStyle titleStyle=workbook.createCellStyle();
		 titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 HSSFFont titleFont=workbook.createFont();
		 titleFont.setFontHeightInPoints((short)20);
		 titleFont.setBoldweight((short)700);
		 titleStyle.setFont(titleFont);
		 
		 //��ͷ��ʽ
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
		 
		 //��Ԫ����ʽ
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
		 
		 //����һ��������ı��
		 HSSFSheet sheet=workbook.createSheet();
		 //����һ����ͼ�Ķ���������
		 HSSFPatriarch  patriarch=sheet.createDrawingPatriarch();
		 //����ע�͵Ĵ�С��λ��
		 HSSFComment comment=patriarch.createComment(
				 new HSSFClientAnchor(0,0,0,0,(short)4,2,(short)6,5));
		 //����ע������
		 comment.setString(new HSSFRichTextString("������POI���ע�ͣ���"));
		 //����ע�����ߣ�������ƶ�����Ԫ�����ǿ�����״̬���п�������
		 comment.setAuthor("qxq");
		 //�����п�
		 int minBytes=colWidth<DEFAULT_COLUMN_WIDTH?DEFAULT_COLUMN_WIDTH:colWidth;
		 int [] arrColWidth=new int[headMap.size()];
		 //�����������У��Լ������п�
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
		 
		 //�����������ݣ�����������
		 int rowIndex=0;
		 for (Object obj :jsonArray) {
			if(rowIndex==65535||rowIndex==0){
				if(rowIndex!=0){
					//������ݳ����ˣ����ڵڶ�ҳ��ʾ
					sheet=workbook.createSheet();
				}
				
				//��ͷrowIndex=0;
				HSSFRow titleRow=sheet.createRow(0);
				titleRow.createCell(0).setCellValue(title);
				titleRow.getCell(0).setCellStyle(titleStyle);
				sheet.addMergedRegion(new CellRangeAddress(0,0,0,headMap.size()-1));
				
				//��ͷrowIndex=1
				HSSFRow headerRow=sheet.createRow(1);
				for (int i = 0; i < headers.length; i++) {
					headerRow.createCell(i).setCellValue(headers[i]);
					headerRow.getCell(i).setCellStyle(headerStyle);
				}
				
				//�������ݴ�rowIndex=2��ʼ
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
