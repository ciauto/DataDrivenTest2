package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllCellValues {

	public static void main(String[] args) throws IOException {
		//specify the excel file containing test data
		File src=new File("C:\\eclipse-workspace-201906\\DataDrivenTest2\\src\\testdataMT_002.xlsx");
		//load the excel file
		FileInputStream fis=new FileInputStream(src);
		//load the workbook from the above excel file 
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//load the sheet from above excel workbook
		XSSFSheet sheet=wb.getSheetAt(0);
		
		
		// how many total rows in my excel sheet
		int rowCount=sheet.getLastRowNum();
		System.out.println(rowCount);
		
		int rows = rowCount + 1;
		System.out.println(rows);
		
		
		for(int i=1; i<=rowCount; i++) {
			//Reading first column(getCell refer to Column)
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Excel data is:  "+data);
		}
		//close the workbook		
		wb.close();
		}
}
