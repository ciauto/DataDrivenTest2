package util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public ExcelReader(String excelpath){
	try {
		File src = new File(excelpath);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet1=wb.getSheetAt(0);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	public String getData(int Sheetnumber, int row, int col)
	{
		sheet1=wb.getSheetAt(Sheetnumber);
		String data=sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	//Method return the number of rows in excel sheet
	public int getRowCount(int sheetIndex)
	{
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
	

}

