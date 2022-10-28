package com.ixl.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class sample {


	static int sleeptime = 1000;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Software Testing\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ixl.com/signin");
		
		
		driver.manage().window().maximize(); 
		
		Thread.sleep(sleeptime);
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("nikitaudayakumar151");
		
		Thread.sleep(sleeptime);
		WebElement password = driver.findElement(By.id("sipassword"));
		password.sendKeys("trip18");
		
		Thread.sleep(sleeptime);
		WebElement submit = driver.findElement(By.id("signin-button"));
		submit.submit();
		/*
		Thread.sleep(sleeptime);
		WebElement math = driver.findElement(By.xpath("//a[@class='subcategory-link sub-nav-subcat-math ']"));
		math.click();
		
		Thread.sleep(sleeptime);
		WebElement mathlink1 = driver.findElement(By.xpath("//a[@href='/math/grade-3/even-or-odd-addition-patterns']"));
		mathlink1.click();
	*/
		Thread.sleep(sleeptime);
		WebElement errmsg = driver.findElement(By.id("signin-page-error"));
		if(errmsg.getText().equalsIgnoreCase("Your username or password is incorrect"))
		{ 
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		
		
		
		
		
	}
}
