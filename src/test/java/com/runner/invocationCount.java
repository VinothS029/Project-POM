package com.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class invocationCount {
	@Test(invocationCount = 5)
	private void browser() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

}
