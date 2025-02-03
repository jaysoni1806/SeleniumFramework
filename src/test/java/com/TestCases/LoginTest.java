package com.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BaseClass.BrowserSetup;

public class LoginTest extends BrowserSetup {
	
	@Test
	public void LoginValidTest()
	{
		driver.findElement(By.xpath("//div[@id='test']")).clear();
	}

}
