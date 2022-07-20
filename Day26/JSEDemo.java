package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSEDemo {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.ferguson.com/";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		WebElement txtSearch;
		txtSearch = driver.findElement(By.xpath("//input[@class='text-input search react-search-input-normal js-reload-value']"));
		txtSearch.sendKeys("Water Softner");
		
		WebElement lnkSearch;
		lnkSearch = driver.findElement(By.xpath("//input[@class='icon i-search h-clean-btn react-search-close']/following-sibling::a"));
		
		//Javascript execution using selenium webdriver
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lnkSearch);
				
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
