package com.smart.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataprovider3 {

//	@DataProvider(name = "getData")
//	public String[] getData() {
//
//		return new String[] { "sharmin", "Rumon", "ProSmart", "lala", "farhana" };
//	}

	@Test(dataProvider = "getData", dataProviderClass = DataSupplier.class)
	public void loginTest(String username) {
		System.out.println(username + "logged in to the application.");
	}

}
