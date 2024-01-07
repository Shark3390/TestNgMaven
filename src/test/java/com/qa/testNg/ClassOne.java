package com.qa.testNg;

import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassOne {

	// created a method called googletest
	@Test
	public void googleTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("ProSmart", Keys.ENTER);
		String actualtitle = driver.getTitle();
		String expectedTitle = "ProSmart - Google Search";// your requirments will tell you the expected title
//		Assert.assertEquals(actualtitle, expectedTitle);
		assertEquals(actualtitle, expectedTitle, "Title did not match >>");

		driver.quit();
	}

	@Test
	public void facebookTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("ProSmart", Keys.ENTER);
		driver.findElement(By.name("login")).click();
		String title = driver.getTitle();
		System.out.println(title);

		driver.quit();

	}

}
