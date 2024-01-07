package com.smart.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest2 {

	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class)
	public void testLogin(String name, String pass) {
		System.out.println(name + " logged in to the application with " + pass);

	}

}
