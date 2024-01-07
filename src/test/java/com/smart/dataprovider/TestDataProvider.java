package com.smart.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataProvider {
	@Test(dataProvider = "getData")
	public void testOrangeHRM(String userName, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		String actual = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		SoftAssert soft = new SoftAssert();
		String expected = "Dashboard";
		soft.assertEquals(actual, expected, "Invalid credentials >> ");
		soft.assertAll();
		driver.close();
	}

	@DataProvider(name = "getData")
	public Object[][] testData() {
		return new Object[][] { { "Admin", "admin123" }, 
			{ "username1", "password1" }, 
			{ "username2", "password2" } };
	}
}
