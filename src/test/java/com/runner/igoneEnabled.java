package com.runner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.reusableclass.BaseClass;

public class igoneEnabled extends BaseClass{
	
	@Test(priority = -1)
	public void browser() {
		launchBrowser("Chrome");
	}
	
	@Test(priority = 3, enabled = false)
	public void urllaunch() {
		launchUrl("https://www.facebook.com/");
	}
	
	@Test(priority =7)
	public void login() {
		inputPassing(driver.findElement(By.name("email")), "vinoth");
	}
	@Test(priority =9)
	public void terminatebrowser() {
		driver.quit();;
	}

}
