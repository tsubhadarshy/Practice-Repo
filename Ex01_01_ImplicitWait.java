package ch4_auto.beyond;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.Configuration;

class Ex01_01_ImplicitWait {

	@Test
	void test() {
		//create the driver
		
		WebDriver driver = Configuration.createChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//login
		driver.get(Configuration.ADMIN_URL);
		WebElement userTextBox = driver.findElement(By.name("log"));
		userTextBox.sendKeys(Configuration.USER_NAME);
		WebElement pwdTextBox = driver.findElement(By.name("pwd"));
		pwdTextBox.sendKeys(Configuration.PASSWORD);
		pwdTextBox.submit();
		boolean dBoardLoaded = driver.findElement(By.id("wpadminbar")).isDisplayed();
		assertTrue(dBoardLoaded, "Assert that dashboard is loaded");
		
		//logout
		WebElement logOut = driver.findElement(By.xpath("//*[text() = 'Log Out']"));
		driver.get(logOut.getAttribute("href"));

		WebElement logOutMsg = driver.findElement(By.xpath("//*[contains(text(), 'logged out')]"));
		assertTrue(logOutMsg.isDisplayed(), "Assert successful logout. ");
		driver.quit();
		
	}

}