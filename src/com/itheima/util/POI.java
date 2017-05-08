package com.itheima.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.itheima.domain.Book;

public class POI {
	public static void excel(List<Book> list) throws IOException{
		String path = ServletActionContext.getServletContext().getRealPath("/");
		InputStream inputStream = new FileInputStream(new File(path+"/poiModel/borrow_book_model.xls"));
		Workbook wb = new HSSFWorkbook(inputStream);
		int rowNo = 2;
		
		Sheet sheet = wb.getSheet("Sheet0");
		Row row = null;
		Cell cell = null;
		//获取样式
		row = sheet.getRow(rowNo);
		
		cell = row.getCell(1);
		CellStyle style1 = cell.getCellStyle();
		
		cell = row.getCell(2);
		CellStyle style2 = cell.getCellStyle();
		
		cell = row.getCell(3);
		CellStyle style3 = cell.getCellStyle();
		
		cell = row.getCell(4);
		CellStyle style4 = cell.getCellStyle();
		
		cell = row.getCell(5);
		CellStyle style5 = cell.getCellStyle();
		
		cell = row.getCell(6);
		CellStyle style6 = cell.getCellStyle();
		
		cell = row.getCell(7);
		CellStyle style7 = cell.getCellStyle();
		
		//写入数据
		for (Book book : list) {
			row = sheet.createRow(rowNo++);
			cell = row.createCell(1);
			cell.setCellValue(book.getNo());
			cell.setCellStyle(style1);
			
			cell = row.createCell(2);
			cell.setCellValue(book.getName());
			cell.setCellStyle(style2);
			
			cell = row.createCell(3);
			cell.setCellValue(book.getPrice());
			cell.setCellStyle(style3);
			
			cell = row.createCell(4);
			cell.setCellValue(book.getUser().getUsername());
			cell.setCellStyle(style4);
			
			cell = row.createCell(5);
			cell.setCellValue(book.getUser().getEmail());
			cell.setCellStyle(style5);
			
			cell = row.createCell(6);
			cell.setCellValue(book.getUser().getPhone());
			cell.setCellStyle(style6);
			
			cell = row.createCell(7);
			cell.setCellValue(book.getStart());
			cell.setCellStyle(style7);
			
			
		}
		
		
		
//		FileOutputStream outputStream = new FileOutputStream(new File("c:\\理学院科技实践创新中心借书记录.xls"));
		
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();			//生成流对象
		wb.write(byteArrayOutputStream);													//将excel写入流

		//工具类，封装弹出下载框：		
		String outFile = "c:\\理学院科技实践创新中心借书记录.xls";
		DownloadUtil down = new DownloadUtil();
		down.download(byteArrayOutputStream, ServletActionContext.getResponse(), outFile);
		
		
//		wb.write(outputStream);
//		outputStream.flush();
//		outputStream.close();
		
		System.out.println("printing ...");
		
	}
	
}
