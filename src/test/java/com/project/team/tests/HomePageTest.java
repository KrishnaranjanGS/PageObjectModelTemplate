package com.project.team.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.team.base.BaseTest;
import com.project.team.pages.HomePage;

public class HomePageTest extends BaseTest{

	@Test
	public void HomePageTitleTest() {
		boolean flag = homePage.getHomePageTitle();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void HomePageURLTest() {
		boolean flag = homePage.getHomePageURL();
		Assert.assertTrue(flag);
	}
}
