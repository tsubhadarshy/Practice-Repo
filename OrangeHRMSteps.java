package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMSteps {
	
	
	WebDriver driver;
	WebDriverWait wait;
	@Given("^User is on \"([^\"]*)\" page$")
	//@Given("^User is on  \"(.*)\" page$")
	public void OpenLoginPage(String appURL) {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,60);
		driver.get(appURL);
	//	driver.get("https://alchemy.hguy.co//jobs//wp-admin");
		
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void loginToApp(String username, String password) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Then("^User view the Dashboard page$")
	public void viewtheDashboard() {
		String strtitle = driver.getTitle();
	//	Assert.assertTrue(strtitle.contains("Dashboard"));
		System.out.println(strtitle);
	}
	
	 @And("^Navigate to the Recruitment page$")	
	    public void openRecruitmentPage() throws Throwable {
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")));
		driver.findElement(By.linkText("Recruitment")).click();
		 
	 }
	 
	 @And("^Navigate to the vacancies page$")	
	    public void openvacanciesPage() throws Throwable {
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Vacancies")).click();
	//	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menu_recruitment_viewJobVacancy']")));
	//	driver.findElement(By.xpath("//a[@id='menu_recruitment_viewJobVacancy']")).click();
		 
	 }
	 
	 @And("^Navigate to the Add Job Vacancy form$")	
	    public void openAddJobVacancyPage() throws Throwable {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnAdd']")));
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		 
	 }
	
	
	 @And("^Select the Users Menu$")	
	    public void selectUsermenu() throws Throwable {	
	        driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-users']")).click();;	
	    }
	 @And("^click on the Add button to add candidateinformation$")	
	    public void addNewUser() throws Throwable {	
	        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();	
	    }
	 
	 @And("^Input the Job Vacancy details as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	    public void enterUserDetails(String jobTitle, String vacancyName, String hiringManager, String numOfPosition) throws Throwable {	
		 	Select jTitle = new Select(driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']")));
		 	jTitle.selectByVisibleText(jobTitle);
	        driver.findElement(By.xpath("//input[@id='addJobVacancy_name']")).sendKeys(vacancyName);
	        driver.findElement(By.xpath("//input[@id='addJobVacancy_hiringManager']")).sendKeys(hiringManager);
	        driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys(numOfPosition);
	        
	    }
	 
	 @And("^Click the Save button$")
	 public void submituserdetails(){
		 driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	 }
	 
	 @Then("^Verify \"([^\"]*)\" is added in Vacancy dropdown$")
	 public void VerifyVacancydropdown(String expOption) {
		 Boolean optionFlag = false;
		 Select vacancy = new Select(driver.findElement(By.xpath("//select[@id='candidateSearch_jobVacancy']")));
		 List<WebElement> optionsList = vacancy.getOptions();
		 for (WebElement option : optionsList) {
			// System.out.println(option.getText());
			 if (expOption.equals(option.getText())){
				 optionFlag = true;
				 break;
			 }
            
		 }
		 Assert.assertTrue(optionFlag);
		 
	 }
	 
	 @Then("^Add new candidate details$")
	    public void addCandidate() {
	    	wait = new WebDriverWait(driver, 5);
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	
	    	driver.findElement(By.linkText("Recruitment")).click();
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	driver.findElement(By.linkText("Candidates")).click();
	    	driver.findElement(By.id("btnAdd")).click();
	    	driver.findElement(By.id("addCandidate_firstName")).sendKeys("Rakesh");
	    	driver.findElement(By.id("addCandidate_lastName")).sendKeys("kumar");
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	driver.findElement(By.id("addCandidate_email")).sendKeys("rake@gmail.com");
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	 WebElement uploadElement = driver.findElement(By.id("addCandidate_resume"));
	    	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	         // enter the file path onto the file-selection input field
	         uploadElement.sendKeys("C:\\Raksh\\Tranning\\SDET\\OrangeHRM\\Resources\\RakeshResume.docx");
	         driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	         driver.findElement(By.id("btnSave")).click();
	         driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	         driver.findElement(By.id("btnBack")).click();
	         String gettingtext =	driver.findElement(By.linkText("Rakesh kumar")).getText();
	        Assert.assertEquals("Rakesh kumar", gettingtext);  	    
	    	
	    }
	 
	 @Then("^click on the PIM and add new candidate$")
	    public void adduser() {
	    	wait = new WebDriverWait(driver, 5);
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	    	
	    	driver.findElement(By.linkText("PIM")).click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    	
	    	driver.findElement(By.linkText("Employee List")).click();
	    	driver.findElement(By.id("btnAdd")).click();
	    	driver.findElement(By.id("chkLogin")).click();
	    	}
	
  
    @And("^Close the browser$")	
     public void closeBrowser() throws Throwable {	
        driver.quit();	
     }
}
