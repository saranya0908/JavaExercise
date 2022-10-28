package com.gmail.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	static int sleeptime = 1000;
	WebDriver driver;

	@Given("I have a browser opened with IXL website")
	public void i_have_a_browser_opened_with_ixl_website() {
		System.setProperty("webdriver.chrome.driver", "C:\\Software Testing\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ixl.com/signin");
		driver.manage().window().maximize();
		System.out.println("test");
	}
	
	@When("I enter correct user id and password")
	public void i_enter_correct_user_id_and_password() throws Exception {

		Thread.sleep(sleeptime);
		WebElement username = driver.findElement(By.id("siusername"));
		username.sendKeys("nikitaudayakumar151");

		Thread.sleep(sleeptime);
		WebElement password = driver.findElement(By.id("sipassword"));
		password.sendKeys("trip18");
	}
	
	@When("click on submit button")
	public void click_on_submit_button() throws InterruptedException {
		Thread.sleep(sleeptime);
		WebElement signin = driver.findElement(By.xpath("//button[@class='submit-button crisp-button']"));
		signin.submit();
	}
	
	@Then("I should be able to navigate to home page")
	public void i_should_be_able_to_navigate_to_home_page() throws Exception {
		Thread.sleep(sleeptime);
		if(!driver.getCurrentUrl().equalsIgnoreCase("https://www.ixl.com/recommendations")) {
			System.out.println(driver.getCurrentUrl());
			throw new Exception("Login Failed");
		}
	}

}
