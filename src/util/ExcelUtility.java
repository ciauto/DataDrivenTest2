package util;

public class ExcelUtility {
	
	public String[][] getTestData(String sheetName){
		String[][] testData=null;
		
		ExcelReader config=new ExcelReader(System.getProperty("user.dir")+"\\src\\testdataMT_003.xlsx");
		int rows=config.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for(int i=0; i<rows; i++)
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		return testData;
	}
}
