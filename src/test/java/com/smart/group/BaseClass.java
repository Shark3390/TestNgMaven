package com.smart.group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static SoftAssert soft = new SoftAssert();

	@BeforeTest
	public void initializeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

//		switch (browserName.toLowerCase()) {
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			System.out.println("This browser is not supported.");
//		}

		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		soft.assertAll();
		driver.quit();
	}
}
