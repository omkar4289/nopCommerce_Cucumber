package nopCommerce_Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features/Customers.feature"},
                 glue= {"stepDefinitions"},
                 dryRun=false,
                 monochrome=true,
               // tags="@smoke",
		         plugin= {"pretty","html:target/HTMLreports/report.html"}		
		        )

public class TestRun {

} 
