package com.project.team.utils;

import org.openqa.selenium.WebDriver;


public class ElementUtils {

	private WebDriver driver;

//	Constructor:
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
//	Utilities:
	/**
	 * get page title
	 */
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("page title: " + pageTitle);
		return pageTitle;
	}

	/**
	 * get the page URL
	 */
	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("page URL: " + pageUrl);
		return pageUrl;
	}
}
