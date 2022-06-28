package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFile {
	
	@Test
	public static void FileExcel() throws IOException  {
		File file=new File("C:\\Users\\Mohammed D Hossain\\Desktop\\FileRead.xlsx");
		FileInputStream make1= new FileInputStream(file);
		XSSFWorkbook make2= new XSSFWorkbook(make1);
		XSSFSheet make3=make2.getSheet("Sheet1");
		Row make4=make3.getRow(0);
		Cell cell=make4.getCell(0);
		System.out.println(cell.getRichStringCellValue().toString());
	}

}
