package com.smart.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupplier {

	@DataProvider(name = "getData")
	public String[] getData() {

		return new String[] { "sharmin", "Rumon", "ProSmart", "lala", "farhana" };
	}

	@DataProvider(name = "loginData2")
	public String[][] loginData() {

		return new String[][] { 
			{ "username1", "password1" }, 
			{ "username2", "password2" },
			{ "username3", "password3" } 
		};

	}

}
