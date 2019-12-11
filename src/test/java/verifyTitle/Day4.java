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

public class Day4 {

	WebDriver driver;
	String baseUrl = "http://live.demoguru99.com/index.php/";

	@Test
	public void f() throws InterruptedException {

		pageObjectModel p = new pageObjectModel(driver);
		p.clickMobile();
		p.clickCompare("'Sony Xperia'");
		p.clickCompare("'IPhone'");
		p.clickCompareButton();

		// switch to pop up window

		System.out.println("before:::::" + driver.getWindowHandle());
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(handle);
		}

		System.out.println("After:::::" + driver.getWindowHandle());

		String popUpTitle = p.getPopUpTitle();
		String expectedTitle = "COMPARE PRODUCTS";
		Assert.assertEquals(popUpTitle, expectedTitle);

		// make sure that the products are added

		List<WebElement> list = driver.findElements(By.className("product-name"));
		System.out.println(list.size());

		ArrayList<String> stringList = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {

			System.out.println("********" + list.get(i).getText());
			stringList.add(list.get(i).getText());
		}

		ArrayList<String> expectedStringList = new ArrayList<String>();
		expectedStringList.add("SONY XPERIA");
		expectedStringList.add("IPHONE");

		for (int i = 0; i < expectedStringList.size(); i++) {
			System.out.println(expectedStringList.get(i));
		}

		Assert.assertEquals(stringList, expectedStringList);

	}
	
	@Test
	public void secondTest() throws InterruptedException {

		pageObjectModel p = new pageObjectModel(driver);
		p.clickMobile();
		p.clickCompare("'Sony Xperia'");
		p.clickCompare("'IPhone'");
		p.clickCompareButton();

		// switch to pop up window

		System.out.println("before:::::" + driver.getWindowHandle());
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(handle);
		}

		System.out.println("After:::::" + driver.getWindowHandle());

		String popUpTitle = p.getPopUpTitle();
		String expectedTitle = "COMPARE PRODUCTS";
		Assert.assertEquals(popUpTitle, expectedTitle);

		// make sure that the products are added

		List<WebElement> list = driver.findElements(By.className("product-name"));
		System.out.println(list.size());

		ArrayList<String> stringList = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {

			System.out.println("********" + list.get(i).getText());
			stringList.add(list.get(i).getText());
		}

		ArrayList<String> expectedStringList = new ArrayList<String>();
		expectedStringList.add("SONY XPERIA");
		expectedStringList.add("IPHONE");

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
		driver.switchTo().window("18");
		driver.close();
	}

}
