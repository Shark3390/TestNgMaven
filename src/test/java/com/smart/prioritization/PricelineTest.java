package com.smart.prioritization;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PricelineTest {
	@Ignore
	@Test (groups = {"regression"})
	public void createAccount() {
		System.out.println("Account created");
	}
	@Test (groups = {"regression", "smoke"})
	public void Login() {
		System.out.println("Login completed");
	}
	@Test (groups = {"sanity"})
	public void searchFlight() {
		System.out.println("Flight identified");
	}
	@Test (groups = {"smoke"})
	public void checkout() {
		System.out.println("Checkout complete");
	}
	@Test (groups = {"regression", "sanity"})
	public void logout() {
		System.out.println("Log out successful");
	}

}
