package testcases;

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
public class LoginMT_002 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(dataProvider="credential")
	public void login(String uname, String pword) throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pword);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
	}
	@DataProvider(name="credential")
		public Object[][] passdata(){
			
			ExcelReader config=new ExcelReader("C:\\eclipse-workspace-201906\\DataDrivenTest2\\src\\testdataMT_002.xlsx");
			int rows=config.getRowCount(0); //Sheet #
			System.out.println(rows);
			
			Object[][] data = new Object[rows][4];
			
			for(int i=1; i<rows; i++) {
				data[i][0]=config.getData(0, i, 0);
				data[i][1]=config.getData(0, i, 1);
				data[i][2]=config.getData(0, i, 2);
				data[i][3]=config.getData(0, i, 3);
			}
		return data;
		}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	}
