package com.AdminPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		WebElement dash1 = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6"));

		// Check if login is success or not
		Assert.assertTrue(dash1.isDisplayed());

		if (dash1.isDisplayed() == true) {
			System.out.println("Login successfull....");
		}
	}
}
