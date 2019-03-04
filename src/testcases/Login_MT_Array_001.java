package testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_MT_Array_001 {
	@Test(dataProvider="credential")
	public void login(String username, String password) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Find a Flight"));
		driver.quit();
		}
	@DataProvider(name="credential")
	public Object[][] passdata(){
		//create 2D array name data with 3 rows and 2 column
		Object[][] data = new Object[3][2];
		//we have input data 	
		data[0][0]="tutorial";
		data[0][1]="tutorial";
		data[1][0]="Tye";
		data[1][1]="tutorial";		
		data[2][0]="Naresh";
		data[2][1]="tutorial";
		return data;
		}
}
