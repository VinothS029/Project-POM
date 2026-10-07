package com.reusableclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {
	
	public static WebDriver driver;
	
	protected static void launchBrowser(String browserName) {
		
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			
		}
		
	}
	
	protected static void launchUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			
		}
		
	}
	
	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			
		}
	}

	protected static void inputPassing(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			
		}
		
	}
	
	protected static void staticWait(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			
		}
	}
	
	protected static void clickSearchbtn(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			
		}
	}
	protected static void pageTitle() {
		try {
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			
		}
	}
	
	protected static void getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options =  select.getOptions();
		System.out.println(options);
	}
	
	protected static void getFirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}
	
	protected static void getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions =  select.getAllSelectedOptions();
		System.out.println(allSelectedOptions);
	}
	
	protected static void isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean isMultipleDropdown = select.isMultiple();
		System.out.println(isMultipleDropdown);
	}
	
	protected static void getText(WebElement element) {
		try {
			element.getText();
			System.out.println(element.getText());
		} catch (Exception e) {
			
		}
	}
	
	protected static void implicitWait(WebElement element, String type, int milliseconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(milliseconds));
		
		if(type.equalsIgnoreCase("elementVisible")) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}else if(type.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
	    }else if(type.equalsIgnoreCase("selected")) {
			wait.until(ExpectedConditions.elementToBeSelected(element));
	    }else if(type.equalsIgnoreCase("presence")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	    }
	}

		
	protected static void navigationMethods(String types) {
		if(types.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}else if(types.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}else if(types.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
	}
	
	protected static void takeScreenShot() throws Throwable {
		try {
			Date currentDate = new Date();
			String replace = currentDate.toString().replace(" ", "_").replace(":", " ");
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("C:\\Users\\Vinoth Sekar\\eclipse\\DemoBlaze\\Screenshots" + replace + ".png"));
		} catch (WebDriverException e) {
			
		}
		
	}
	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			
		}
	}
	protected static void closecurrentpage() {
		try {
			driver.quit();
		} catch (Exception e) {
			
		}
	}
	
	protected static void navigateTo(String navigateUrl) {
		try {
			driver.navigate().to(navigateUrl);
		} catch (Exception e) {
			
		}
	}
	
	protected static void javaExecute(WebElement element, String type) {
		
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			if(type.equalsIgnoreCase("scroll into view")) {
				jse.executeAsyncScript("argument[0].scrollIntoView(true);", element);
			}if(type.equalsIgnoreCase("scroll down")) {
				jse.executeScript("window.scrollBy(0,4000);");
			}else if(type.equalsIgnoreCase("scroll up")) {
				jse.executeScript("window.scrollBy(0,-3500);");
			}else if(type.equalsIgnoreCase("send keys")) {
				jse.executeScript("arguments[0].setAttribute('value', 'vinoth');",element);
			}else if(type.equalsIgnoreCase("Click")) {
				jse.executeScript("arguments[0].click()", element);
			}
			
		} catch (Exception e) {	
	  }		
	}
	
	protected static void alterHandle(String type) {
		try {
			Alert alert = driver.switchTo().alert();
			
			if(type.equalsIgnoreCase("accept")) {
				alert.accept();
			}else if(type.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			
		}		
	}
	
	protected static void promptAlert(String value) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
		} catch (Exception e) {
			
		}
	}
	
	protected static void robotMethods(String type) {
		try {
			Robot robot = new Robot();
			if(type.equalsIgnoreCase("enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}else if(type.equalsIgnoreCase("clear")) {
				robot.keyPress(KeyEvent.VK_CLEAR);
				robot.keyRelease(KeyEvent.VK_CLEAR);
			}else if(type.equalsIgnoreCase("tab")) {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}else if(type.equalsIgnoreCase("esc")) {
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
			}
		} catch (AWTException e) {
			
		}
	}
	
	protected static void selectDropDown(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}else if(type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("visibletext")) {
				select.selectByVisibleText(value);
			}
		} catch (NumberFormatException e) {
			
		}
	}
	
	protected static void deSelectDropDown(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}else if(type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("visibletext")) {
				select.deselectByVisibleText(value);
			}
		} catch (NumberFormatException e) {
			
		}
	}
	
	protected static void isSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}
	
	protected static void isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}
	
	protected static void isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	
	protected static void windowHandle(int windowid) {
		try {
			List<String> allwindow = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(allwindow.get(windowid));
		} catch (Exception e) {
			
		}
	}
	
	protected static void actionMethods(WebElement element, String type) {
		try {
			Actions action = new Actions(driver);
			if(type.equalsIgnoreCase("click")) {
				action.click(element).perform();
			}else if(type.equalsIgnoreCase("doubleclick")) {
				action.doubleClick(element).perform();
			}else if(type.equalsIgnoreCase("rightclick")) {
				action.contextClick(element).perform();
			}else if(type.equalsIgnoreCase("movetoElement")) {
				action.moveToElement(element).perform();
			}
		} catch (Exception e) {
			
		}
	}
}
