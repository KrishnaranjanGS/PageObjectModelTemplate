package com.project.team.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.team.constants.ProjectConstants;
import com.project.team.utils.ElementUtils;

public class HomePage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
//	Declare locators below:
	private By homePageLogo = By.xpath("");
	
//	Page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Write page action methods below:
	public boolean getHomePageTitle() {
		String title = eleUtils.getPageTitle();
		if(title.equals(ProjectConstants.HOME_PAGE_TITLE_VALUE)) {
			System.out.println("Home page title is correct.");
			return true;
		}
		else {
			System.out.println("Home page title is NOT correct.");
			return false;
		}
	}
	
	public boolean getHomePageURL() {
		String url = eleUtils.getPageUrl();
		if(url.equals(ProjectConstants.HOME_PAGE_URL_VALUE)) {
			System.out.println("Home page URL is correct.");
			return true;
		}
		else {
			System.out.println("Home page URL is NOT correct.");
			return false;
		}
	}

}
