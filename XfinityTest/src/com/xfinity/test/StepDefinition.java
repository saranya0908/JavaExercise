package com.xfinity.test;

import com.xfinity.test.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;

public class StepDefinition {
	static int sleeptime = 3000;
	WebDriver driver;

	public void driverInitiation() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void loginAuthentication(String username, String password) throws Exception {
		JavascriptEnabled javascriptEnabledCapability = new JavascriptEnabledCapability(false);
		driver.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, javascriptEnabledCapability);
		
		driver.navigate().to("https://login.xfinity.com/login");
		Thread.sleep(sleeptime);
		driver.manage().window().maximize();
		//Thread.sleep(sleeptime);
		//driver.navigate().back();
		//Thread.sleep(sleeptime);
		//driver.navigate().forward();

		Thread.sleep(sleeptime);
		WebElement username1 = driver.findElement(By.id("user"));
		username1.sendKeys(username);

		Thread.sleep(sleeptime);
		WebElement letsgobtn = driver.findElement(By.id("sign_in"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", letsgobtn);
		//letsgobtn.click();

		Thread.sleep(sleeptime);
		WebElement pwd = driver.findElement(By.id("passwd"));
		pwd.sendKeys(password);

		Thread.sleep(sleeptime);
		WebElement letsgobtn2 = driver.findElement(By.id("sign_in"));
		letsgobtn2.submit();

	}

	public void validateAuthentication() throws Exception {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.xfinity.com/auth")) {
			System.out.println("login successful");
		} else {
			System.out.println("login failed");
		}
	}

	public void testXfinity() {

	}
}
