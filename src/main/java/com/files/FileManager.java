package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FileManager {
	
	//@Test
	public static void getExcel() throws IOException {
		String user=FileManager.readExcel("C:\\Users\\Mohammed D Hossain\\Desktop\\FileRead.xlsx", "Safa", "A2");
		String pass=FileManager.readExcel("C:\\Users\\Mohammed D Hossain\\Desktop\\FileRead.xlsx", "Safa", "B2");
		System.out.println(user +" " +pass );
	}

	public static String readExcel(String path, String sheetName, String cellName) throws IOException {
       DataFormatter format= new DataFormatter();
       String value=null;
		File file = new File(path);
		FileInputStream files = new FileInputStream(file);
		XSSFWorkbook web = new XSSFWorkbook(files);
		XSSFSheet shet = web.getSheet(sheetName);
		CellAddress ca = new CellAddress(cellName);
		Row row = shet.getRow(ca.getRow());
		Cell cell = row.getCell(ca.getColumn());
		value=format.formatCellValue(cell).toString();
		return value;
		
	}
	
	public static String[][] readExcelFile(String path,String sheetName) {
		String data[][]=null;
		DataFormatter formatter=new DataFormatter();
		try {
		File file=new File(path);
		FileInputStream fileInput=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fileInput);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowSize= sheet.getPhysicalNumberOfRows();
		int colSize=sheet.getRow(0).getLastCellNum();
		data=new String[rowSize][colSize];
			Iterator<Row> rowIterator=sheet.rowIterator();
			int rowCount=0;	
			while(rowIterator.hasNext()) {
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				int colCount=0;
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					data[rowCount][colCount]=formatter.formatCellValue(cell).toString();
					colCount++;
				}
				rowCount++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
		}

}
