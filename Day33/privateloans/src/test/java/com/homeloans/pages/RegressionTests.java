package com.homeloans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegressionTests extends BaseClass{
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void googleSearch() throws InterruptedException {
		driver.get("http://www.google.co.in");
		WebElement txtSearch;
		txtSearch = driver.findElement(By.xpath("//input[@name='q']"));
		txtSearch.sendKeys("Latest Samsung mobile phones" + Keys.ENTER);
		Thread.sleep(4000);
		Assert.assertTrue(driver.getTitle().contains("Iphone"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
