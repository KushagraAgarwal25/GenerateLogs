package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	//what is log? capturing info/activities at the time of program execution
	//types of logs
	    //1. info
		//2. warning
		//3. error
 		//4. fatal
	
	//how to generate the logs? :use  Apache log4j API (log 4j jar)
	//How it works? : it read 4j configuration from log4j.properties file
	//where to create? create inside resource folder
	

	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver_win32_version79\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://ui.freecrm.com/");

	}

	
	@Test
	public void freeCRMTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test
	public void loginTest() {
		driver.findElement(By.name("email")).sendKeys("kush.ag25@gmail.com");
		driver.findElement(By.name("password")).sendKeys("KushAnshul");
		driver.findElement(By.xpath("//*[(@class='ui fluid large blue submit button')]")).click();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
