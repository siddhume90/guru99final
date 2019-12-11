package verifyTitle;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

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
import verifyTitle.pageObjectModel;

public class day1 {

	WebDriver driver;
	String baseUrl = "http://live.demoguru99.com/index.php/";

	@SuppressWarnings("null")
	@Test
	public void test() {

		pageObjectModel p = new pageObjectModel(driver);

		// verify title
		String title = p.verifyTitle();
		String expectedTitle = "THIS IS DEMO SITE FOR   ";

		System.out.println(title);
		Assert.assertEquals(title, expectedTitle);
		// click mobile
		p.clickMobile();

		// verify Mobile Title
		String mtitle = p.getTitleMobile();
		String expectedMTitle = "MOBILE";
		System.out.println(mtitle);
		Assert.assertEquals(mtitle, expectedMTitle);

		// show sorting optins
		p.showOptions();
		// sort by Name
		p.clickName();
		
		//make sure that list is sorted

		List<WebElement> list = driver.findElements(By.xpath("//li[@class='item last']//h2"));
		System.out.println(list.size());
 
		  ArrayList<String> stringList = new ArrayList<String>();
		

		for (int i = 0; i < list.size(); i++) {
			
						System.out.println("********" + list.get(i).getText());
						stringList.add(list.get(i).getText());
		}
		
		 ArrayList<String> expectedStringList = new ArrayList<String>();
		 expectedStringList.add("IPHONE");
		 expectedStringList.add("SAMSUNG GALAXY");
		 expectedStringList.add("SONY XPERIA");
		 
		 for (int i = 0; i < expectedStringList.size(); i++) {
			 System.out.println(expectedStringList.get(i));
		 }
		 
		 Assert.assertEquals(stringList, expectedStringList);
		 
		
	
	
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
		driver.close();
	}

}
