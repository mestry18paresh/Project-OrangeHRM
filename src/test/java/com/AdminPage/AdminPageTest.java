package com.AdminPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminPageTest {

	WebDriver driver;
	LoginPage loginPage;
	AdminPage adminPage;

	@BeforeTest
	public void configuration() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		loginPage = new LoginPage(driver);
		adminPage = new AdminPage(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		loginPage.login();
	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void selectAdminMenuTest() {
		//Select admin option and print all all available options.
		adminPage.selectAdminMenu();
	}

	@Test(priority = 3, dependsOnMethods = "selectAdminMenuTest")
	public void selectUserNameTest() throws InterruptedException {
		adminPage.selectUserName("Admin");
		System.out.println("User Name = ");
		adminPage.displayResult();
	}

	@Test(priority = 4, dependsOnMethods = "selectAdminMenuTest")
	public void selectUserRoleTest() throws InterruptedException{
		adminPage.selectUserRole("Admin");
		System.out.println("User Role = ");
		adminPage.displayResult();
	}

	@Test(priority = 5, dependsOnMethods = "selectAdminMenuTest")
	public void selectUserStatusTest() throws InterruptedException{
		adminPage.selectUserStatus("Enabled");
		System.out.println("User Status = ");
		adminPage.displayResult();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
