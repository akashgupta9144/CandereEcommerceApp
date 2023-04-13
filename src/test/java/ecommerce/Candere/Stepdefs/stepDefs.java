package ecommerce.Candere.Stepdefs;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce.Candere.POM.LandingPageObject.FooterLandingPage;
import ecommerce.Candere.POM.LandingPageObject.LandingPageObject;
import ecommerce.Candere.POM.LandingPageObject.SearchPageObject;
import ecommerce.Candere.core.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefs {
 
	Scenario scn;
	String baseURL = "https://www.candere.com/";
	WebDriver driver;
	WebDriverWait wait;
	int timeOut = 20;
	

	LandingPageObject landingPageObject; 
	FooterLandingPage footerLandingPage;
	SearchPageObject searchPageObject;

	@Before
	public void setupBrowser(Scenario scn) {
		this.scn = scn;
		try {
			String browser = WebDriverFactory.getBrowserName();
			driver = WebDriverFactory.getWebDriverForBrowser(browser);
			scn.log("user setup the browser: " + browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, timeOut);
		scn.log("webDriver wait is :" + timeOut + "second");

		landingPageObject = new LandingPageObject(driver, wait);
		searchPageObject = new SearchPageObject(driver, wait);
		footerLandingPage=new FooterLandingPage(driver, wait);
	}

	@After(order = 2)
	public void failedPageScreenShot(Scenario scn) {
		if (scn.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(screenShot, "image/png", "the failed page Name is: " + scn.getName());
		}
	}

	@After(order = 1)
	public void terminate() {
		driver.quit();
		scn.log("close the browser");
	}

	@Given("User navigate to the landing page URL of the Application")
	public void user_navigate_to_the_landing_page_url_of_the_application() {
		WebDriverFactory.navigateToTheUrl(baseURL);
		scn.log("User navigate to the landing page URL of the Application");

	}

	@Given("validate the landing page of the application")
	public void validate_the_landing_page_of_the_application() { 
		landingPageObject.validateLandingPage();
		scn.log("validate the landing page of the application");
	}

	@When("User is searching the product {string}")
	public void user_is_searching_the_product(String productName) {
		landingPageObject.searchProduct(productName);
		scn.log("User is searching the product: " + productName);

	} 

	@Then("User click the selected product")
	public void User_click_the_selected_product() {
		landingPageObject.clickProductForDetails();
		scn.log("User is select and click  the product");
	}

	@Then("Validate the searching product details page of the application")
	public void Validate_the_searching_product_details_page_of_the_application() {
		searchPageObject.ValidateProductDetailPage();
		scn.log("validate the searching product details page of the application");
	}

	@Then("User select the size of the product is {string}")
	public void user_select_the_size_of_the_product(String size) {
		searchPageObject.selectRingSize(size);
		scn.log("User select the size of the product is: "+ size);
	}

	@Then("Validate the selected size of the product")
	public void validate_the_selected_size_of_the_product() {
		searchPageObject.ValidateSizeofRing();
		scn.log("Validate the selected size of the product");
	}
	
	@When("User Scroll Down the landing page of the application")
	public void user_scroll_down_the_landing_page_of_the_application() {
	    footerLandingPage.scrollLandingPage();
	    scn.log("User Scroll Down the landing page of the application");
	}


	@Then("validate options under the ABOUT US section of the landing page")
	public void validate_options_under_the_about_us_section_of_the_landing_page(List<String> expectedOptions) {
		footerLandingPage.validate_ABOUT_US_options(expectedOptions);
		scn.log("validate options under the ABOUT US section of the landing page");
		
	}
	@When("User Scroll Down the landing page") 
	public void user_scroll_down_the_landing_page() {
		footerLandingPage.scrollpage();
	    scn.log("User Scroll Down the landing page of the application");
	}
	
	@Then("User select and validate the {string}")
	public void user_select_and_validate_the(String options) {
		footerLandingPage.click_Follow_Us_option(options);
		scn.log("User Scroll Down the landing page of the application");
	}


	

}
