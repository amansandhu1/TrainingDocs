package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {

	public static void main(String[] args) throws InterruptedException {
		// strong[text()='France']/preceding::input[1]

		String url = "https://cosmocode.io/automation-practice-webtable/";
		String countryName = "Iraq";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);

		WebElement countriesVisited;
		countriesVisited = driver.findElement(By.xpath("//strong[text()='" + countryName + "']/preceding::input[1]"));
		countriesVisited.click();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
