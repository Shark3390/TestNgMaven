package com.smart.invocationCount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestInvocation {

	@Test(invocationCount = 6, threadPoolSize = 2)
	public void testMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("user_value")).getText());
		driver.close();
	}

}
