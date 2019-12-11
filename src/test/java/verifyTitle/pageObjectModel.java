package verifyTitle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class pageObjectModel {
	WebDriver driver;

	public pageObjectModel(WebDriver driver) {
		this.driver = driver;

	}

	public String verifyTitle() {
		WebElement title = driver.findElement(By.className("page-title"));
		String output = title.getText();
		return output;

	}

	public void clickMobile() {
		WebElement mobileTab = driver
				.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']"));
		mobileTab.click();
	}

	public String getTitleMobile() {
		WebElement title = driver.findElement(By.className("page-title"));
		String output = title.getText();
		return output;
	}

	public void showOptions() {
		WebElement showOptions = driver
				.findElement(By.xpath("//select[@onchange='setLocation(this.value)' and @title='Sort By']"));
		showOptions.click();
	}

	public void clickName() {
		WebElement byName = driver.findElement(
				By.xpath("//option[@value='http://live.demoguru99.com/index.php/mobile.html?dir=asc&order=name']"));
		byName.click();
	}

	public void isListSorted() {
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='item last']//h2"));
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println("********" + list.get(i).getText());

		}

		String expectedValue = "IPHONE";
		String lastExpectedValue = "SONY XPERIA";

		Assert.assertEquals(list.get(0).getText(), expectedValue);
		Assert.assertEquals(list.get(2).getText(), lastExpectedValue);

	}

	public String sonyPrice() {
		WebElement price = driver.findElement(By.id("product-price-1"));

		String output = price.getText();
		// System.out.println(output);

		return output;

	}

	public String getPrice(String mobile) {

		return mobile;

	}

	public void clickProduct(String phoneName) {
		WebElement clickProduct = driver.findElement(
				By.xpath("//a[contains(text()," + phoneName + ")]//parent::h2//parent::div//parent::li/a"));
		clickProduct.click();

	}

	public String getPriceMobilePage(String phoneName) {

		String priceString = "//a[contains(text()," + phoneName + ")]//parent::h2//parent::div/div[1]/span/span";
		WebElement wPrice = driver.findElement(By.xpath(priceString));
		return wPrice.getText();
	}

	public String getPriceSecondPage(String phoneName) {

		WebElement price = driver.findElement(
				By.xpath("//span[text()=" + phoneName + "]//parent::div//parent::div//div[@class='price-box']"));
		String secondPagePrice = price.getText();
		return secondPagePrice;
	}

	//
	// a[contains(text(),'Sony Xperia')]//parent::h2//parent::div/div[1]/span/span
	// a[contains(text(),'IPhone')]//parent::h2//parent::div/div[1]/span/span

	public void clickCompare(String phoneName) {
		WebElement clickCompare = driver.findElement(
				By.xpath("//a[contains(text()," + phoneName + ")]//parent::h2//parent::div/div[3]/ul/li[2]"));
		clickCompare.click();
	}

	public void clickCompareButton() {
		WebElement clickCompare = driver
				.findElement(By.xpath("//ol[@id='compare-items']//parent::div/div/button/span/span"));

		clickCompare.click();
	}

	public String getPopUpTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 3);

		WebElement title = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title title-buttons']/h1")));
		String output = title.getText();
		return output;
	}

	public void clickAddCartSony() {
		WebElement clickAddCartSony = driver.findElement(By
				.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']/li[1]/div/div[3]/button"));

		clickAddCartSony.click();
	}

	public void inputQuanitity(String quantity) {
		WebElement input = driver.findElement(By.xpath("//input[@class='input-text qty']"));

		input.clear();
		input.sendKeys(quantity);

	}

	public void updateCart() {
		WebElement update = driver.findElement(By.xpath("//button[@class='button btn-update']"));
		update.click();

	}

	public String getShopingCartErrorMsg() {
		WebElement error = driver.findElement(By.className("item-msg"));
		String output = error.getText();
		return output;
	}

	public void clickEmptyCard() {
		WebElement emptyCart = driver.findElement(By.xpath("//td[@class='a-center product-cart-remove last']/a"));
		emptyCart.click();

	}

	public String emptyCartConfirmation() {
		WebElement msg = driver.findElement(By.className("page-title"));
		String output = msg.getText();
		return output;
	}

	public void clickAcount() {
		WebElement clickAccount = driver.findElement(By.xpath("//a[@class='skip-link skip-account']/span[2]"));
		clickAccount.click();

	}

	public void clickMyAccount() {
		driver.findElement(By.linkText("MY ACCOUNT")).click();
	}

	public void clickCreateAccount() {
		driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
		;
	}

	public void clickLogin() {
		driver.findElement(By.linkText("Log In")).click();
	}

	public void enterEmailForLogin(String login) {
		driver.findElement(By.id("email")).sendKeys(login);
		;
	}

	public void enterPasswordForLogin(String password) {
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(By.id("send2")).click();
	}

	public void clickTv() {
		WebElement tvTab = driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/tv.html']"));
		tvTab.click();
	}
	
	public void addSamsungToWishList() {
		
		String xpathString="//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/div/div[3]/ul/li[1]/a";
		String cssStr="[class=\"products-grid products-grid--max-4-col first last odd\"] >li:nth-of-type(2) ul li:nth-of-type(1)";
		//driver.findElement(By.xpath(xpathString)).click();
		driver.findElement(By.cssSelector(cssStr)).click();

		
		//		WebDriverWait wait = new WebDriverWait(driver,3 );
//
//		WebElement tvtab = wait.until(
//				ExpectedConditions.visibilityOfElementLocated
//				(By.xpath("//a[@href='http://live.demoguru99.com/index.php/wishlist/index/add/product/5/form_key/2efnWjUHWodfHD29/']")));
//		
		//driver.findElement(By.linkText("Add to Wishlist")).click();
				//tvtab.click();
	}
	
public void addSamsung1ToWishList() {
		
		String xpathString="//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/div/div[3]/ul/li[1]/a";
		String cssStr="[class=\"products-grid products-grid--max-4-col first last odd\"] >li:nth-of-type(2) ul li:nth-of-type(1)";
		//driver.findElement(By.xpath(xpathString)).click();
		driver.findElement(By.cssSelector(cssStr)).click();

		
		//		WebDriverWait wait = new WebDriverWait(driver,3 );
//
//		WebElement tvtab = wait.until(
//				ExpectedConditions.visibilityOfElementLocated
//				(By.xpath("//a[@href='http://live.demoguru99.com/index.php/wishlist/index/add/product/5/form_key/2efnWjUHWodfHD29/']")));
//		
		//driver.findElement(By.linkText("Add to Wishlist")).click();
				//tvtab.click();
	}
	
//"//button[@title='Share Wishlist']"
	
	public void clickShareWishList() {
		WebElement tvTab = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
		tvTab.click();
	}
	
	public void shareEmail(String email) {
		driver.findElement(By.id("email_address")).sendKeys(email);
	}
}
