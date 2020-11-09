package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo {

	WebDriver driver;//interface which contains the browser details
	
	
	  @Test(dataProvider = "dp")
	  public void f(String n, String s) throws InterruptedException {
		  
		  driver.findElement(By.id("txtUsername")).sendKeys(n);
		  driver.findElement(By.id("txtPassword")).sendKeys(s);
		  driver.findElement(By.name("Submit")).click();
		  
		  //Assert.assertEquals(actual, expected);
		  
		  Thread.sleep(10000);
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	  }

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "admin", "admin123" },
	      
	    };
	  }
	  @BeforeTest
	  public void beforeTest() 
	  {
		  System.setProperty("webdriver.chrome.driver", "/Users/mohammad.suhail/Desktop/restassured_jars/Selenium/chromeDriver/chrome86/chromedriver");
		  driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com");
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
