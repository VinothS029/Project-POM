package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static Object[][] getExcelData(String filePath, String sheetName){
		Object[][] data = null;
		
		try (FileInputStream fileInputStream = new FileInputStream(filePath); 
			Workbook workBook = new XSSFWorkbook(fileInputStream)){
				Sheet sheet = workBook.getSheet(sheetName);
				int totalRows = sheet.getLastRowNum();
				short totalColumns = sheet.getRow(0).getLastCellNum();
				data = new Object[totalRows][totalColumns];
				for(int i =1; i <= totalRows; i++) {
					Row row = sheet.getRow(i);
					 for(int j = 0; j < totalColumns; j++) {
						 Cell cell = row.getCell(j);
						 data[i-1][j] = (cell == null) ? "" : cell.toString();
			}
		}
			
		} catch (IOException e) {
			
		}
		return data;
	}    }

	



