package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	WebDriver driver;
	LoginPage lp;
	AddcustomerPage addCust;
	SearchCustomerPage searchCust;
	
	public static String randomString()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	
	public void waitForElement(WebElement element, long timeOutInSeconds)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}	
	

}
