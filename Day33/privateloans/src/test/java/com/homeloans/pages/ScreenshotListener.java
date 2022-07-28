package com.homeloans.pages;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ScreenshotListener extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
		File destFile = new File(reportDirectory + "/failure_screenshots/" + result.getName() + dtf.format(now) + ".png");
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		
	}

}
