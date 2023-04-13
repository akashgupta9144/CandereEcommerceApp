package ecommerce.Candere.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	
		features = "classpath:Features", 
        glue = "ecommerce.Candere.Stepdefs", 
        tags = "@follow_Us", 
        plugin = { "pretty",
        		"html:target/html/htmlreport.html",
        		"json:target/json/file.json", },
        monochrome = true,
        publish = true,
        dryRun = false


)
	 
public class TestRunner {
	
}
