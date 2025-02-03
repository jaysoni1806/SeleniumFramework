package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.Listeners.ExtentReport;
import com.WebUtility.ExtentReportManager;


public class BrowserSetup {

	public static WebDriver driver;
	private static Properties prop;

	@BeforeSuite
	public void browserSetup() throws FileNotFoundException, IOException {

		propertySetup(); // Call propertySetup() method
		driver = new ChromeDriver(); // Chrome launch
		driver.manage().window().maximize(); // Maximize the browser
		driver.get(prop.getProperty("url")); // Lunch URL in the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Globle wait for 10 second
		
		

	}
	@BeforeTest
	public void initializeExtentReport() {

		ExtentReportManager.ExtentReport();
	}
	@AfterTest
	public void flush() {
		ExtentReport.flush();
	}

	public void propertySetup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
