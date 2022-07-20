package day27;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://demoqa.com/alerts";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		
		WebElement btn;
		btn = driver.findElement(By.xpath("//button[@id='alertButton']"));
		btn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
