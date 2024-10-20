package com.AdminPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectAdminMenu() {
		List<WebElement> menuList = driver
				.findElements(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li"));

		System.out.println("OrangeHRM Total List of options: " + menuList.size());

		for (WebElement menu : menuList) {
			// Select Admin option
			if (menu.getText().equals("Admin")) {
				menu.click();
				return;
			}
		}
		System.out.println("Admin option not found.....");
	}

	public void selectUserName(String selectUser) {
		// Select User name "Admin"
		WebElement usernameInput = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		usernameInput.click();
		usernameInput.sendKeys(selectUser);
	}

	public void selectUserRole(String selectRole) {
		// Select User role "Admin"
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i"))
				.click();

		List<WebElement> recordList1 = driver.findElements(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div"));

		for (int i = 0; i < recordList1.size(); i++) {

			String nm = recordList1.get(i).getText();
			if (nm.contains(selectRole)) {
				recordList1.get(i).click();
				return;
			}
		}

	}

	public void selectUserStatus(String selectEnabled) {
		// Select status "Enabled"
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i"))
				.click();

		List<WebElement> statusList = driver.findElements(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div"));

		for (int i = 0; i < statusList.size(); i++) {

			String nm = statusList.get(i).getText();
			if (nm.contains(selectEnabled)) {
				statusList.get(i).click();
				return;
			}
		}

	}

	public void displayResult() throws InterruptedException {

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Display result
		System.out.println("Display Result : - " + driver
				.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText());

		// Refresh Page
		driver.navigate().refresh();

	}

}
