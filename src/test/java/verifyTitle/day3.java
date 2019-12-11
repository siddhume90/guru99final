package verifyTitle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class day3 {
	
	WebDriver driver;
	String baseUrl = "http://live.demoguru99.com/index.php/";

  @Test
  
  public void f() {
	  
		pageObjectModel p = new pageObjectModel(driver);
		p.clickMobile();
		p.clickAddCartSony();
		p.inputQuanitity("1000");
		p.updateCart();
		String errorMsg=p.getShopingCartErrorMsg();
		System.out.println(errorMsg);
		String expectedMsg="* The maximum quantity allowed for purchase is 500.";
		Assert.assertEquals(errorMsg, expectedMsg);
		p.clickEmptyCard();
		String emptyCartMessage=p.emptyCartConfirmation();
		System.out.println(emptyCartMessage);
		String expectedEmtyCartMessage="SHOPPING CART IS EMPTY";
		Assert.assertEquals(emptyCartMessage, expectedEmtyCartMessage);
		
		
		
				
		
		
		
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
	 // driver.close();
  }

}
