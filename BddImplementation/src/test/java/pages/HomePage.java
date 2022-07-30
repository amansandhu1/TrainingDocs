package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends BaseClass {

	public HomePage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, HomePage.class);
		
	}

	@FindBy(xpath = "//input[@name='q']")
	WebElement txtSearch;

	public void openGoogle() {
		driver.get("https://www.google.co.in");
	}
	public void searchText() {
		txtSearch.sendKeys("New James Bond Movies" + Keys.ENTER);
	}
	
	public void assertText() {
		Assert.assertTrue(driver.getTitle().contains("James Bond"));
		
	}
	
	public void closeApp() {
		driver.close();
		driver.quit();
	}

}
