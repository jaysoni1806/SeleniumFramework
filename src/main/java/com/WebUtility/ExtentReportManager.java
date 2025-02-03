package com.WebUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentreports;
	public static ExtentTest test;
	
	public static void ExtentReport() {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report/" + "MyReport.html");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setDocumentTitle("TestReport");
		extentreports = new ExtentReports();
		extentreports.attachReporter(extentSparkReporter);
	}
	public static void flush()
	{
		extentreports.flush();
	}

}
