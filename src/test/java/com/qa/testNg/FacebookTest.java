package com.qa.testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest {

	/*
	 * Q4. Go to https://www.facebook.com , pass ~!@#*& in the email field and hit
	 * enter. From the landing page capture the following items: a) Title b) Url c)
	 * Value of the email field d) Texts (two texts in two different lines) of the
	 * error message e) Background-color value of the error message (which comes in
	 * light red shed) Add soft assertions for all the extracted values ## Note that
	 * for asserting background color, you need to convert the hexadecimal color
	 * code (extracted from the Styles tab of dev tools for the web element) to RGBA
	 * value. You can do the conversion using the following website Hex to RGBA
	 * (rgbacolorpicker.com)
	 */

	@Test
	public void facebookTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("~!@#*&", Keys.ENTER);

		Thread.sleep(3000);

		SoftAssert soft = new SoftAssert();

		String expectedTitle = "Log into Facebook";
		String errorMessage = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
		String expectedColor = "1px solid rgb(240, 40, 73)";

		String actualTitle = driver.getTitle();
		String actualUrl = driver.getCurrentUrl();
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		String actualColor = driver.findElement(By.xpath("//input[@id='email']")).getCssValue("border");

		soft.assertEquals(actualTitle, expectedTitle, "Title mismatch!");

		soft.assertTrue(actualUrl.contains("https://www.facebook.com/login/?"));
		soft.assertEquals(actualErrorMessage, errorMessage, "Message mismatch!");
		soft.assertEquals(actualColor, expectedColor, "Color mismatch!");

		soft.assertAll();
		driver.close();

	}

}
