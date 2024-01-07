package com.smart.group;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PricelineTest {
	@Ignore
	@Test (priority = -1)
	public void createAccount() {
		System.out.println("Account created");
	}
	@Test (priority = 2)
	public void Login() {
		System.out.println("Login completed");
	}
	@Test (priority = 3)
	public void searchFlight() {
		System.out.println("Flight identified");
	}
	@Test (priority = 4)
	public void checkout() {
		System.out.println("Checkout complete");
	}
	@Test (priority = 5)
	public void logout() {
		System.out.println("Log out successful");
	}

}
