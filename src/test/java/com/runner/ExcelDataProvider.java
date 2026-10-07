package com.runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utility.ExcelUtility;

public class ExcelDataProvider {
	@DataProvider(name = "excelDataProvider")
	public Object[][] dataProviderMethod(){
		String filepath = System.getProperty("user.dir") + "\\Excel\\TestData.xlsx";
		String sheetName = "data";
		return ExcelUtility.getExcelData(filepath, sheetName);
	}
	@Test(dataProvider = "excelDataProvider")
	private void userLogin(String username, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Username :" + username + "| Password :" + password);
	}

}
