package com.smart.group2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass extends BaseClass {

	@Test(testName = "GoogleTest", groups = {"smoke"})
	public void testGoogle() {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("ProSmart", Keys.ENTER);
		String expectedTitle = "ProSmart - Google Search";
		String actualTtitle = driver.getTitle();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTtitle, expectedTitle, "Title mismatch!");
		soft.assertAll();
//		driver.close();
	}

	@Test(testName = "Facebook", groups = {"regression", "smoke"})
	public void testFacebook() {
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("~!@#*&", Keys.ENTER);
		String actualurl = driver.getCurrentUrl();
//		soft.assertTrue(actualurl.contains("https://www.facebook.com/login/?"));
//		soft.assertAll();
//		driver.close();

	}

	@Test(testName = "OrangeHRMTest", groups = { "sanity" })
	public void testOrangeHRM(String actual, String expected) {
		driver.get("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.tagName("Dashboard")).click();
//		soft.assertEquals(actual, expected, ("invalid credentials >>"));
//		soft.assertAll();
//		driver.close();
	}
}
