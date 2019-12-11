package verifyTitle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Day2 {

	WebDriver driver;
	String baseUrl = "http://live.demoguru99.com/index.php/";

	@Test
	public void Sony()  {

		pageObjectModel p = new pageObjectModel(driver);
		p.clickMobile();

		String pricePage1 = p.getPriceMobilePage("'Sony Xperia'");

		System.out.println("************ Sony Xperia " + pricePage1);

		p.clickProduct("'Sony Xperia'");
		String pricePage2 = p.getPriceSecondPage("'Sony Xperia'");
		System.out.println("Price of sony page 2 " + pricePage2);

		Assert.assertEquals(pricePage1, pricePage2);

	}
	@Test
	public void Iphone() {

		pageObjectModel p = new pageObjectModel(driver);
		p.clickMobile();

		String pricePage1 = p.getPriceMobilePage("'IPhone'");

		System.out.println("************ IPhone " + pricePage1);

		p.clickProduct("'IPhone'");
		String pricePage2 = p.getPriceSecondPage("'IPhone'");
		System.out.println("Price of IPhone 2 " + pricePage2);

		Assert.assertEquals(pricePage1, pricePage2);

	}


	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get(baseUrl);

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sehaj Singh\\Desktop\\Selenium\\geckodriver.exe");

	}

	@AfterTest
	public void afterTest() {
		
	}

}
