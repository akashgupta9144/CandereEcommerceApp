package ecommerce.Candere.POM.FollowUSLinkPageObeject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce.Candere.POM.LandingPageObject.SearchPageObject;

public class LinkPageObject {
	Logger logger = LogManager.getLogger(SearchPageObject.class);
	WebDriver driver;
	WebDriverWait wait;
	
	By option_FB=By.xpath("//div//h1[text()='Candere by Kalyan Jewellers']");
	By option_Insta=By.xpath("//div//h2[text()='canderejewellery']");
	By option_twitter=By.xpath("//div[@class='css-901oao r-1awozwy r-18jsvk2 r-6koalj r-37j5jr r-adyw6z r-1vr29t4 r-135wba7 r-bcqeeo r-1udh08x r-qvutc0']//span[text()='Candere By Kalyan Jewellers']");
	
	
	public LinkPageObject(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		
	}
	 
	public void validate_followUS_Option_Facebook() {
		
		WebElement validate_FB_page=wait.until(ExpectedConditions.elementToBeClickable(option_FB));
		Assert.assertTrue(validate_FB_page.isDisplayed());
		logger.info("Validation of FB option is passed: "+validate_FB_page.getText());
		String FacebookURL=driver.getCurrentUrl();
		logger.info("URL of Facebook Page is : "+FacebookURL+"\n");
		
		}
	public void validate_followUS_Option_Instagram() {
		
		WebElement validate_Insta_page=wait.until(ExpectedConditions.elementToBeClickable(option_Insta));
		Assert.assertTrue(validate_Insta_page.isDisplayed());
		logger.info("Validation of Instagram option is passed: "+validate_Insta_page.getText());
		String FacebookURL=driver.getCurrentUrl();
		logger.info("URL of Instagram Page is : "+FacebookURL+"\n");
			
	}
	public void validate_followUS_Option_Twitter() {
		
		WebElement validate_Twitter_page=wait.until(ExpectedConditions.elementToBeClickable(option_twitter));
		Assert.assertTrue(validate_Twitter_page.isDisplayed());
		logger.info("Validation of Twitter option is passed: "+validate_Twitter_page.getText());
		String TwitterURL=driver.getCurrentUrl();
		logger.info("URL of Twitter Page is : "+TwitterURL+"\n");
		
	}
	}