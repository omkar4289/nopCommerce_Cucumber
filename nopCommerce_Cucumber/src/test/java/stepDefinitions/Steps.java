package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
		
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
     String path= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path+"\\src\\test\\resources\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}
	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		     lp=new LoginPage(driver);
             lp.emailEntered(email);
             lp.passwordEntered(password);
		
	}
	@And("Click on Login")
	public void click_on_login() {
         lp.clickedLogin();
	}
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
                String pageTitle=driver.getTitle();
                Assert.assertEquals(title, pageTitle);
                System.out.println("=========== "+title+" verified successfully =========");
	}
	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
           lp.clickedLogOut();
	}
	@And("close browser")
	public void close_browser() {
         driver.close();
	}
	
	//Add New Customer .......
	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException{
		addCust=new AddcustomerPage(driver);
		  addCust.clickCustomerMenu();
			

	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException  {
		addCust=new AddcustomerPage(driver);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addCust.clickCustomerOption();
	}
	@When("click on Add new button")
	public void click_on_add_new_button() {
		addCust.clickAddNew();
		
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
          Assert.assertEquals(driver.getTitle(), "Add a new customer / nopCommerce administration");
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException  {
		Thread.sleep(2000);
             addCust.addEmailId();
             addCust.addPassword();
             addCust.addFirstName();
             addCust.addLastName();
             addCust.maleSelect();
             //addCust.selectDatePicker();
             addCust.enterDate();
             addCust.enterCompany();
             Thread.sleep(2000);
             addCust.setManagerVendor();
             Thread.sleep(2000);
             addCust.AdminContent();
            Thread.sleep(2000);
             addCust.setCustomerRoles();
             
		
	}
	@When("click on save button")
	public void click_on_save_button() {
              addCust.clickSave();
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
             Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
             System.out.println("===============Confirmation message verified successfully==================");
	}

	//Search customer by using emailID
	
	@When("enter customer email")
	public void enter_customer_email() throws InterruptedException {
		searchCust=new SearchCustomerPage(driver);
		Thread.sleep(3000);
		searchCust.enterSearchEmail("victoria_victoria@nopCommerce.com");
		
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust=new SearchCustomerPage(driver);
		searchCust.clickOnSearch();
		Thread.sleep(3000);
	}
	@Then("user should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
       Assert.assertTrue(searchCust.searchByEmail("victoria_victoria@nopCommerce.com"));        
	}
	
	//Search customer by Name
	@When("enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		searchCust=new SearchCustomerPage(driver);
		//Thread.sleep(3000);
		searchCust.enterFirstName("Victoria");
	}
	@When("enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
		//Thread.sleep(3000);
       searchCust.enterLastName("Terces");
	}
	@Then("user should found Name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
		//Thread.sleep(3000);
		boolean status=searchCust.searchByName("Victoria Terces");
		Assert.assertTrue(status);
		System.out.println("=============Status of searchByName verified");
	}
	@And("select customer role")
	public void select_customer_role() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']/ul/li")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Registered']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Guests']")).click();
		
	}

	@Then("user should see only {string} customers in the search table")
	public void user_should_see_only_customers_in_the_search_table(String role) throws InterruptedException {
		searchCust=new SearchCustomerPage(driver);
		boolean status=searchCust.checkCustomerRoles(role);
		Assert.assertTrue(status);
		System.out.println("====================Customer roles verified successfully");
	}



}
