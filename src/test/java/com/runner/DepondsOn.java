package com.runner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.reusableclass.BaseClass;

public class DepondsOn extends BaseClass {
	@Test
	public void browser() {
		launchBrowser("Chrome");
	}
	
	@Test(dependsOnMethods = "browser")
	public void urllaunch() {
		launchUrl("https://www.facebook.com/");
	}
	
	@Test(dependsOnMethods = "urllaunch")
	public void login() {
		inputPassing(driver.findElement(By.name("email")), "vinoth");
	}
	@Test(priority =6)
	public void terminatebrowser() {
		driver.quit();;
	}


}
