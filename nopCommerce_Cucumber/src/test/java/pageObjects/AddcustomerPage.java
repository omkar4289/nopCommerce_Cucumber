package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinitions.BaseClass;

public class AddcustomerPage extends BaseClass{

	WebDriver driver;
	public AddcustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='nav-link']/p[contains(text(),'Customers')]")
	WebElement Customers;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']")
	WebElement custOption;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	WebElement AddNew;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement addEmail;
	
	@FindBy(id="Password")
	WebElement addPass;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="Gender_Male")
	WebElement male;
	
	
	@FindBy(xpath="//span[@class='k-icon k-i-calendar']")
	WebElement datePick;
	
	@FindBy(id="DateOfBirth")
	WebElement Dateset;
	
	@FindBy(id="Company")
	WebElement companyName;
	
	@FindBy(id="AdminComment")
	WebElement setAdminContent;
	
	@FindBy(id="VendorId")
	WebElement drpDownVendor;
	
	@FindBy(xpath="//span[@class='k-select' and @title='delete']")
	WebElement deselectRole;
	
	@FindBy(xpath="(//div[@role='listbox'])[2]")
	WebElement CustomerRoles;
	
	@FindBy(xpath="//span[text()='Registered']")
	 WebElement deSelectRegester;
	
	@FindBy(xpath="//li[text()='Registered']")
	WebElement register;
	
	@FindBy(xpath="//li[text()='Guests']")
	WebElement guest;
	
	@FindBy(xpath="//button[@type='submit' and @name='save']")
	WebElement btn_Save;
	
	public void clickCustomerMenu() throws InterruptedException 
	{
		Thread.sleep(2000);
		waitForElement(Customers, 10);
		Customers.click();
	}
	
	public void clickCustomerOption() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForElement(custOption, 10);
		custOption.click();
	}
	public void clickAddNew()
	{
		AddNew.click();
	}
	public void addEmailId()
	{
		String rendm=randomString();
		addEmail.sendKeys(rendm+"@gmail.com");
	}
	public void addPassword()
	{
		addPass.sendKeys("12345");
	}
	public void addFirstName()
	{
		firstName.sendKeys("Ram");
	}
	public void addLastName()
	{
		LastName.sendKeys("Patil");
	}
	public void maleSelect()
	{
		male.click();
	}
	public void selectDatePicker()
	{
		waitForElement(datePick,10);
		datePick.click();		
	}
	public void enterDate()
	{
		Dateset.sendKeys("12/12/1996");
	}
	
	public void enterCompany()
	{
waitForElement(companyName, 10);
		companyName.sendKeys("QABusy");
		//Thread.sleep(5000);
		
	}
	public void AdminContent()
	{
		setAdminContent.sendKeys("This is for testing......");
	}
	
	public void setManagerVendor()
	{
	Select drpDwn=new Select(drpDownVendor);
	drpDwn.selectByValue("2");
	}
	
	public void setCustomerRoles() throws InterruptedException 
	{
		//Thread.sleep(5000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", deSelectRegester);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForElement(deSelectRegester, 10);
		deSelectRegester.click();
		waitForElement(CustomerRoles, 10);
		//CustomerRoles.click();
		waitForElement(register, 20);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", deSelectRegester);
		register.click();
		//deselectRole.click();
		waitForElement(CustomerRoles, 10);
		//Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", CustomerRoles);
		CustomerRoles.click();
		waitForElement(guest, 5);
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", guest);
		guest.click();
	}
	
	public void clickSave()
	{
		waitForElement(btn_Save, 10);
		btn_Save.click();
	}
	
	
	
	
	
}
