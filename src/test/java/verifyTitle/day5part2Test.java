package verifyTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day5part2Test {
	WebDriver driver;
	String baseUrl = "http://live.demoguru99.com/index.php/";
	

  @Test
  public void f() {
	  pageObjectModel p = new pageObjectModel(driver);
	  p.clickAcount();
	  p.clickLogin();
	  p.enterEmailForLogin("siddhume90@gmail.com");
	  p.enterPasswordForLogin("a8a8a8");
	  p.clickLoginButton();
	  p.clickTv();
	  
	  System.out.println("before:::::" + driver.getWindowHandle());
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(handle);
		}

		System.out.println("After:::::" + driver.getWindowHandle());
	  
	  p.addSamsungToWishList();
	  p.clickShareWishList();
	  p.shareEmail("siddhume90@gmail.com");
	  p.clickShareWishList();
	  
	  
	  
	  
	  
  }
  
  @BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sehaj Singh\\Desktop\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseUrl);

}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}
}