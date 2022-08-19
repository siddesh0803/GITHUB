package org.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameWorks {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	
	
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	
	WebElement login = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
	login.click();
	
	WebElement mobno = driver.findElement(By.xpath("//input[@name='email']"));
	mobno.sendKeys("9080839221");
	
	WebElement log = driver.findElement(By.xpath("//input[@type='submit']"));
	log.click();
	
	WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
	pass.sendKeys("siddesh@0803");
	
	WebElement in = driver.findElement(By.id("signInSubmit"));
	in.click();
	

	
	
}
}
