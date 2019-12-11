package verifyTitle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Day5 {

	WebDriver driver;
	String baseUrl = "http://live.demoguru99.com/index.php/";

	@Test
	public void f() throws InterruptedException {

		pageObjectModel p = new pageObjectModel(driver);
		p.clickMobile();
		p.clickAcount();
		p.clickMyAccount();
		System.out.println("before:::::" + driver.getWindowHandle());
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(handle);
		}

		System.out.println("After:::::" + driver.getWindowHandle());
		
		p.clickCreateAccount();
		
		System.out.println("before:::::" + driver.getWindowHandle());
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(handle);
		}

		System.out.println("After:::::" + driver.getWindowHandle());
		
		
		driver.findElement(By.id("firstname")).clear();	   
	    driver.findElement(By.id("firstname")).sendKeys("sid"); 
	    driver.findElement(By.id("lastname")).clear();	    
	    driver.findElement(By.id("lastname")).sendKeys("D");
	    driver.findElement(By.id("email_address")).clear();
	    driver.findElement(By.id("email_address")).sendKeys("siddhume90@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("a8a8a8");
	    driver.findElement(By.id("confirmation")).clear();
	    driver.findElement(By.id("confirmation")).sendKeys("a8a8a8");
	    
	    
	    driver.findElement(By.xpath("//button[@title='Register']")).click();
	    
	    System.out.println("before:::::" + driver.getWindowHandle());
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(handle);
		}

		System.out.println("After:::::" + driver.getWindowHandle());
		
		
		//click register
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
	    Thread.sleep(2000);
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 5. Verify Registration is done. Expected account registration done.
	    String vWelcome = ("WELCOME, " + "sid" + " " + "D" + "!");
	    String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
	    System.out.println("tWelcome = "+tWelcome);
	    	    
	    try {	    	
	    	assertEquals(tWelcome, vWelcome);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	

	    


		
	}
	
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sehaj Singh\\Desktop\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseUrl);

	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
		//driver.close();
		

}}
