package ecommerce.Candere.POM.LandingPageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce.Candere.POM.FollowUSLinkPageObeject.LinkPageObject;


public class FooterLandingPage {
	Logger logger = LogManager.getLogger(FooterLandingPage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	By footer = By.xpath("//p[text()='ABOUT US']");
	By followUs_footer=By.xpath("//p[text()='FOLLOW US']");
	By ABOUT_US = By.xpath("//div[@class='flex_group_item'][1]//a");
	
	LinkPageObject linkPageObject;
	
	
	public FooterLandingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}


	public void scrollLandingPage() {
		WebElement footerLandingPage = wait.until(ExpectedConditions.elementToBeClickable(footer));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footerLandingPage);
		logger.info("Scroll Down the Landing Page of the application");
	}

	public void validate_ABOUT_US_options(List<String> expectedOptions) {
		
		List<WebElement> ABOUT_US_option = driver.findElements(ABOUT_US);
		for (int i = 0; i < expectedOptions.size(); i++) {
			if (expectedOptions.get(i).equals(ABOUT_US_option.get(i).getText())) {
				Assert.assertTrue(true);
				logger.info("VALIDATION PASSED: ExpectedOption: " + expectedOptions.get(i) + "|| ActualOptions: "
						+ ABOUT_US_option.get(i).getText()+"/n");
				
			} else {
				Assert.fail();
				logger.info("VALIDATION FAILED");
			}
		}
	}
	public void scrollpage() {
		WebElement footerpage = wait.until(ExpectedConditions.elementToBeClickable(followUs_footer));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footerpage);
		logger.info("Scroll Down upto footer of the Landing Page of the application");
	}
	public void click_Follow_Us_option(String options) {
		linkPageObject = new LinkPageObject(driver, wait);
		By FollowUs_link = By.xpath("//div//a[@data-gtm='" + options + "']");

		switch (options.toLowerCase()) {
		case "facebook": {

			WebElement Option1 = wait.until(ExpectedConditions.elementToBeClickable(FollowUs_link));
			Option1.click();
			System.out.println(Option1);
			linkPageObject.validate_followUS_Option_Facebook();
			break;
		}
		case "instagram": {
			WebElement Option2 = wait.until(ExpectedConditions.elementToBeClickable(FollowUs_link));
			System.out.println(Option2);
			Option2.click();
			linkPageObject.validate_followUS_Option_Instagram();
			break;
		}
		case "twitter": {
			WebElement Option3 = wait.until(ExpectedConditions.elementToBeClickable(FollowUs_link));
			System.out.println(Option3);
			Option3.click();
			linkPageObject.validate_followUS_Option_Twitter();
			break;
		}
		default:
			Assert.fail();
			break;
		}
	}
}
