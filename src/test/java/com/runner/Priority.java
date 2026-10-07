package com.runner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.reusableclass.BaseClass;

public class Priority extends BaseClass{
	
	@Test(priority = -1)
	public void browser() {
		launchBrowser("Chrome");
	}
	
	@Test
	public void urllaunch() {
		launchUrl("https://www.facebook.com/");
	}
	
	@Test(priority =4)
	public void login() {
		inputPassing(driver.findElement(By.name("email")), "vinoth");
	}
	@Test(priority =6)
	public void terminatebrowser() {
		driver.quit();;
	}

}
