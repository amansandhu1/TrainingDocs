public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//Resources//chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		driver.get("https://www.online.citibank.co.in/");
		Thread.sleep(2000);
		WebElement lnkCreditCards = driver.findElement(By.xpath("//a[@title='Credit Cards' and @id='topMnucreditcards']"));
		act.moveToElement(lnkCreditCards).perform();
		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}
}
