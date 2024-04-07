package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class SearchCustomerPage extends BaseClass {
	
	WebDriver driver;
	public SearchCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id="SearchEmail")
	public WebElement searchEmail;
	@FindBy(id="SearchFirstName")
	public WebElement SearchFirstName;
	@FindBy(id="SearchLastName")
	public WebElement SearchLastName;
	@FindBy(id="search-customers")
	public WebElement btnSearch;
	@FindBy(xpath="//div[@class='dataTables_scrollBody']/table/tbody/tr")
	public List<WebElement> tableRows;
	@FindBy(xpath="//div[@class='dataTables_scrollBody']/table/tbody/tr/td")
	public List<WebElement> tableColumns;
	public String role;
	
	
	public void enterSearchEmail(String email)
	{
		waitForElement(searchEmail, 10);
		searchEmail.clear();
		searchEmail.sendKeys(email);
	}
	public void enterFirstName(String fName) throws InterruptedException
	{
		Thread.sleep(3000);
		waitForElement(SearchFirstName, 30);
		SearchFirstName.clear();
		SearchFirstName.sendKeys(fName);
	}
	public void enterLastName(String lName) throws InterruptedException
	{
		Thread.sleep(3000);
		waitForElement(SearchLastName, 30);
		SearchLastName.clear();
		SearchLastName.sendKeys(lName);
	}	
	
	public void clickOnSearch() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForElement(btnSearch, 30);
		btnSearch.click();
		Thread.sleep(3000);
	}
	public int getTableRows()
	{
		return(tableRows.size());
	}
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	public boolean searchByEmail(String email)
	{
		waitForElement(driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[3]")), 10);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[2]")) );
		
		boolean flag=false;
		System.out.println("==================getTableRows: "+getTableRows());
		
		for(int i=1;i<=getTableRows();i++)
		{
			String emailid=driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr["+i+"]/td[2]")).getText();
			if(emailid.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchByName(String Name)
	{
		String[] Names=Name.split(" ");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[2]")) );
		
		boolean flag=false;
		System.out.println("==================getTableRows: "+getTableRows());
		
		for(int i=1;i<=getTableRows();i++)
		{
			String name=driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr["+i+"]/td[3]")).getText();
			String[] names=name.split(" ");
			if(Names[0].equals(names[0]) && Names[1].equals(names[1]))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	int count=0;
	public boolean checkCustomerRoles(String role) throws InterruptedException
	{
		
		boolean flag=false;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[4]")) );
		//System.out.println("==================getTableRows: "+getTableRows());
		
		//Thread.sleep(3000);
		
		//Thread.sleep(3000);
		WebElement nextArrow=driver.findElement(By.id("customers-grid_next"));
	//	waitForElement(nextArrow, 10);
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",nextArrow);
		String text=nextArrow.getAttribute("class");
		
			for(int i=1;i<=getTableRows();i++)
			{count++;
			//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ele=driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr["+i+"]/td[4]"));
				String roles;
				try {
					 roles=ele.getText();
					}
					catch(StaleElementReferenceException e){
						ele=driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr["+i+"]/td[4]"));
						 roles=ele.getText();
					}
				
				if(roles.equals("Guests"))
				{
					flag=true;
				}
				
			}
			//waitForElement(nextArrow, 10);
			
			
		if(!(text.contains("disabled")))
		{
			try {
				Thread.sleep(2000);
				nextArrow.click();
				}
				catch(StaleElementReferenceException e){
					Thread.sleep(2000);
					 nextArrow=driver.findElement(By.id("customers-grid_next"));
					 nextArrow.click();
				}
			checkCustomerRoles("Guests");
			}
		
		
		
		System.out.println("=================count: "+count);
	
		
		return flag;
	}
	
	
}
