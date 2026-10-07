package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.reusableclass.BaseClass;

public class Asserts extends BaseClass {
	
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
		WebElement forgot = driver.findElement(By.linkText("Forgotten password?"));
		String actualText = forgot.getText();
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualText, "Forgotten password");
	}
	@Test(priority =6)
	public void terminatebrowser() {
		driver.quit();;
	}


}
