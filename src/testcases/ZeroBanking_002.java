package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ExcelReader;
public class ZeroBanking_002 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test(dataProvider="credential")
		public void login(String uname, String pword) throws InterruptedException{
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		String actualTitle=driver.getTitle();
		String expectedTitle = "Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
		}
	@DataProvider(name="credential")
		public Object[][] passdata() throws IOException{
			
		File src=new File("C:\\eclipse-workspace-201906\\DataDrivenTest2\\src\\testdatazb.xlsx");
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
	
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println(cellCount);

		String data[][] = new String [rowCount][cellCount];

		for(int i=1; i<rowCount+1; i++) {
			Row r=sheet.getRow(i);

			for(int j=0; j<cellCount; j++) {
				System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
			}
		}
			return data;
		
		}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	}
