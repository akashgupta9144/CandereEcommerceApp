package ecommerce.Candere.POM.LandingPageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce.Candere.POM.FollowUSLinkPageObeject.LinkPageObject;

import junit.framework.Assert;

public class LandingPageObject {
	Logger logger = LogManager.getLogger(LandingPageObject.class);
	WebDriver driver;
	WebDriverWait wait;

	By searchBox = By.id("search");
	By click_Product = By.xpath("//div[text()='Majestic Solitaire Diamond Ring']");

	LinkPageObject linkPageObject;

	public LandingPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void validateLandingPage() {
		String expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
		Assert.assertEquals(expected, driver.getTitle());
		logger.info("Validation of the Application landing page is passed and the title is :" + driver.getTitle()+"\n");
		
	}

	public void searchProduct(String productName) {
		WebElement searchProduct = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		searchProduct.sendKeys(productName);
		logger.info("User search the product: " + productName+"\n");
		
	}

	public void clickProductForDetails() {
		WebElement selectedProduct = wait.until(ExpectedConditions.elementToBeClickable(click_Product));
		selectedProduct.click();
		logger.info("click a selected product for search the product Details");

	}
}
