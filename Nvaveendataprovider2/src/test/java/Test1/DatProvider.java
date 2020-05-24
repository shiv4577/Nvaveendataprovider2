package Test1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.TestUtil;

public class DatProvider {

WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
System.setProperty("webdriver.chrome.driver", "E:\\All Selenium Workspace\\Think-App\\ThinkAppProjectV1\\src\\test\\resources\\executables\\chromedriver.exe");
		
		 driver= new ChromeDriver();
		
		driver.get("https://trimitiy.com/shubhavishva/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	
	public Object[][] getLogindata() throws InvalidFormatException, IOException {
		
	Object data[][]=TestUtil.getTestData("RegisterTestCase"); 
		return data;
	}
	
	
	
	@Test(dataProvider="getLogindata")
	
	public void loginTest(String name , String mail, String contact) {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(mail);
		driver.findElement(By.name("mobile")).sendKeys(contact);
		
	}
	
	
	
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
}
