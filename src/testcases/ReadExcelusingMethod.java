package testcases;

import util.ExcelReader;

public class ReadExcelusingMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
					
		ExcelReader er=new ExcelReader("C:\\Users\\Naresh\\oxygen-workspace\\DataDrivenTest2\\resources\\testdata.xlsx");
		
		
		//Read single row or column value in excel sheet
		System.out.println("============Printing single row or cell value ============");
		
		String data=er.getData(0,  1, 2);
		System.out.println(data);
		String data1=er.getData(0,  2, 2);
		System.out.println(data1);
		//Read all values from a particular column
		
		System.out.println("============Printing all rows of a specific column ============");
		int rows=er.getRowCount(0);
		for(int row=1; row<rows; row++) {
			System.out.println(er.getData(0, row, 0));
			}
	}
}
