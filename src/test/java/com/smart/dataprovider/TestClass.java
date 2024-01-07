package com.smart.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	@Test(dataProvider = "searchData")
	public void testGoogle(String search) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys(search, Keys.ENTER);
		String expectedTitle = search + " - Google search";
		String actualTtitle = driver.getTitle();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTtitle, expectedTitle, "Title mismatch!");
		soft.assertAll();
		driver.close();
	}

	@DataProvider(parallel = true)
	public String[] searchData() {
		return new String[] { "ProSmart", "Automation", "Holiday", "cruise" };
	}
}
