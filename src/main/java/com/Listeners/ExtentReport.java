package com.Listeners;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClass.BrowserSetup;
import com.WebUtility.ExtentReportManager;

public class ExtentReport extends ExtentReportManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extentreports.createTest(result.getMethod().getMethodName());
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		
		File directory = new File(System.getProperty("user.dir") + "/screenshots/");
		if (!directory.exists()) {
		    directory.mkdirs(); // Create directory if it does not exist
		}
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) BrowserSetup.driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		File destination = new File(System.getProperty("user.dir") + "/screenshots/ScreenshotsTest.png");
		//File finalDestination = new File(SSPath);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(destination.getAbsolutePath());
		
		//test.fail("Test failed! Screenshot attached.",
               // MediaEntityBuilder.createScreenCaptureFromPath(destination.getAbsolutePath()).build());
	}
}
