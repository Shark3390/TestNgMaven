package com.smart.parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {
	public static WebDriver driver;
	public static SoftAssert soft = new SoftAssert();

	@Parameters("broswerName")
	@BeforeTest
	public void initializeBrowser(@Optional("Chrome") String browserName) {
//determining which browsers to launch.
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("This browser is not supported.");
		}

		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		soft.assertAll();
		driver.quit();
	}

	@Parameters("url")
	@Test
	public void launchApplication(String url) {

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Parameters({ "userName", "password" })
	@Test
	public void loginToTheApplication(String userName, String password) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	}

	@Test
	public void validateLogin() throws InterruptedException {
//		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		String expected = "Dashboard";

		soft.assertEquals(actual, expected, "Invalid credentials >>");

	}

	@Test
	public void navgigateToMyInfo() {
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}

	@Test (enabled = false)
	public void verifyMyInfo() {
		boolean actualStatus = driver.findElement(By.xpath("//h6[text()='Personal Details']")).isDisplayed();
		soft.assertTrue(actualStatus);
	}

}
