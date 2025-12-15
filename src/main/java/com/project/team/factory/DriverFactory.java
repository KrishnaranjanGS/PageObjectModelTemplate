package com.project.team.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {


	public WebDriver driver;
	public static String highlight;
	
	public WebDriver initDriver(String browserName) {
		System.out.println("Browser name is: " + browserName);
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			System.out.println("Launching Chrome browser.");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.out.println("Launching Firefox browser.");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.out.println("Launching Edge browser.");
			driver = new EdgeDriver();
			break;
		case "safari":
			System.out.println("Launching Safari browser.");
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Invalid browser name. Valid browsers are: Chrome, Firefox, Edge, Safari.");
			break;
		}
		if(!(driver==null)) {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
	return driver;
	}
}
