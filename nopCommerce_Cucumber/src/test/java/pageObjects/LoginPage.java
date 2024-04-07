package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	 WebDriver driver;
	 
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement btn_login;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement btn_logout;
	
	public void emailEntered(String email)
	{
		
		Email.clear();
		Email.sendKeys(email);
	}
	public void passwordEntered(String password)
	{
		
		Password.clear();
		Password.sendKeys(password);
	}
	public void clickedLogin()
	{
		btn_login.click();
	}
	public void clickedLogOut()
	{
	    
		btn_logout.click();
	}
	

}
