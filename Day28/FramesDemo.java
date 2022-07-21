package day28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {

	public static void main(String[] args) {
		String url = "https://demoqa.com/frames";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//Set implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("frame1");
		WebElement header;
		header = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(header.isDisplayed());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.close();
		driver.quit();
	}

}
