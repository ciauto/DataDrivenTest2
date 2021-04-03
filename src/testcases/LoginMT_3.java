package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ExcelReader;
import util.ExcelReaderwithDataProviderMethod;
import util.ExcelUtility;

public class LoginMT_3 {
	WebDriver driver;
	ExcelUtility util;
	ExcelReader excel;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	@Test(dataProvider="credential")
		public void login(String username, String password) throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
		}
	@DataProvider(name="credential")
		public String [][] getExcelData() throws IOException{
		
		ExcelReaderwithDataProviderMethod read=new ExcelReaderwithDataProviderMethod();
		
		return read.passData("C:\\Users\\Naresh\\oxygen-workspace\\DataDrivenTest2\\resources\\testdataMT_003.xlsx", "credentials");
		}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	}
