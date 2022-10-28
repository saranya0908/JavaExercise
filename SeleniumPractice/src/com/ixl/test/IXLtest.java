package com.ixl.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IXLtest {
	static int sleeptime = 1000;
	WebDriver driver;

	public static void main(String args[]) throws Exception {

		IXLtest ob = new IXLtest();
		String usrnme = args[0];
		String pwd = args[1];
		// System.setProperty("webdriver.chrome.driver","C:\\Software
		// Testing\\chromedriver_win32\\chromedriver.exe");
		ob.createDriver();
		ob.validateLoginWithCorrectCred(usrnme, pwd);
		ob.getWebsite();
		ob.checkLink();

	}

	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public void validateLoginWithCorrectCred(String usrnme, String pwd) throws Exception {
		driver.get("https://www.ixl.com/signin");
		driver.manage().window().maximize();
		try {
			Thread.sleep(sleeptime);
			WebElement username = driver.findElement(By.id("siusername"));
			username.sendKeys(usrnme);

			Thread.sleep(sleeptime);
			WebElement password = driver.findElement(By.id("sipassword"));
			password.sendKeys(pwd);

			Thread.sleep(sleeptime);
			WebElement signin = driver.findElement(By.xpath("//button[@class='submit-button crisp-button']"));
			signin.submit();
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public void getWebsite() throws Exception {

		try {
			Thread.sleep(sleeptime);
			WebElement teacheref = driver
					.findElement(By.xpath("//button[@class='student-suggested-skills-view-more-container']"));
			teacheref.click();

			Thread.sleep(sleeptime);
			WebElement msg1 = driver.findElement(By.xpath("//a[@class='diagnostic-suggestion']"));
			msg1.getText();
		} catch (Exception e) {
			System.out.println("this is error:" + e.getStackTrace());
		}

		// driver.close();
	}

	public void checkLink() throws Exception {
		try {
			Thread.sleep(sleeptime);
			WebElement msg1 = driver.findElement(By.xpath("//a[@class='diagnostic-suggestion']"));
			msg1.getText();
			if (msg1.getText().equalsIgnoreCase("Start using the Real-time diagnostic!")) {
				System.out.println("TEST PASS");
			} else
				System.out.println("TEST FAIL");
		} catch (Exception e) {
			System.out.println("this is error:" + e.getStackTrace());
		}

		// driver.close();
	}
}