package ecommerce.Candere.POM.LandingPageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class SearchPageObject {
	Logger logger = LogManager.getLogger(SearchPageObject.class);
	WebDriver driver;
	WebDriverWait wait;
	By productDetailValidate = By.xpath("//h1//span[text()='Majestic Solitaire Diamond Ring']");
	By SelectRingSize = By.id("mt_size");
	By successMassage = By.xpath("//div[text()='Price updated']");

	public SearchPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait; 
	} 

	public void ValidateProductDetailPage() {
		WebElement productDetailPageValidation = driver.findElement(productDetailValidate);
		String expected = productDetailPageValidation.getText();
		String actual=driver.getTitle();
		Assert.assertEquals(expected,actual);
		logger.info("Validation of product detail Page is passed: expected: "+expected+"|| Actual: "+actual);
		
	} 

	public void selectRingSize(String ringSize) {
		WebElement RingSize = wait.until(ExpectedConditions.elementToBeClickable(SelectRingSize));
		Select selectSize = new Select(RingSize);
		selectSize.selectByVisibleText(ringSize);
		logger.info("Product Size is selected: "+selectSize);

	}

	public void ValidateSizeofRing() {
		WebElement successMsg = wait.until(ExpectedConditions.elementToBeClickable(successMassage));
		System.out.println(successMsg.getText());
		String excpected = "Price updated";
		Assert.assertTrue(successMsg.isDisplayed());
		logger.info("Validation of product size is passed : Expected: " + excpected + "|| successMsg: " + successMsg.getText()+"\n");
		

	}
}
