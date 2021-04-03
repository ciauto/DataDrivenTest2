package testcases;

import util.ExcelReader;

public class ExamplesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ExcelReader r = new ExcelReader("C:\\eclipse-workspace-201906\\DataDrivenTest2\\src\\testdatazb.xlsx");
		int rows = r.getRowCount(0);
		System.out.println(rows);
		System.out.println(r.getData(0, 2, 0));
		
	}

}
