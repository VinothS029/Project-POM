package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void setUp() {
		System.out.println("SetUp is Done");
	}
	@BeforeTest
	public void browserlaunch() {
		System.out.println("Browser launched successfully");
	}
	@BeforeClass
	public void url() {
		System.out.println("Url launched successfully");
	}
	@BeforeMethod
	public void login() {
		System.out.println("Login Done");
	}
	@Test
	public void IphoneProMax() {
		System.out.println("IphoneProMax order Placed");
	}
	@AfterMethod
	public void logout() {
		System.out.println("Logout");
	}
	@AfterClass
	public void validation() {
		System.out.println("Landed on the Homepage");
	}
	@AfterTest
	public void currentPage() {
		System.out.println("Current Page is Closed");
	}
	@AfterSuite
	public void terminateBrowser() {
		System.out.println("Nothing Order Placed");
	}
	
	

}
