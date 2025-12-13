package com.project.team.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.project.team.factory.DriverFactory;
import com.project.team.pages.HomePage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		driver = df.initDriver("Chrome");
		homePage = new HomePage(driver);
		driver.get("");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
