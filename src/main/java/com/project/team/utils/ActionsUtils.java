package com.project.team.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

	WebDriver driver;
	WaitUtils waitUtils;
	JsUtils jsUtils;

	public ActionsUtils(WebDriver driver) {
		this.driver = driver;
		waitUtils = new WaitUtils(driver);
		jsUtils = new JsUtils(driver);
	}
	
	/**
	 * Enter text in a textbox using Actions class send keys
	 * 
	 * @param locator
	 * @param value
	 */
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(jsUtils.getElement(locator), value).build().perform();
	}
	
	/**
	 * wait for the element to be visible and enabled and move to it using actions class click
	 * @param locator: By locator of the element
	 * @param timeOut: timeout duration in seconds
	 */
		public void waitForElementAndMoveToItWithActions(By locator, int timeOut) {
			WebElement element = waitUtils.waitForElementToBeClickable(locator, timeOut);
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
		}
	/**
	 * wait for the element to be visible and enabled and click on it using actions class click
	 * @param locator: By locator of the element
	 * @param timeOut: timeout duration in seconds
	 */
		public void waitForElementAndClickWithActions(By locator, int timeOut) {
			WebElement element = waitUtils.waitForElementToBeClickable(locator, timeOut);
			Actions act = new Actions(driver);
			act.click(element).build().perform();		
		}
}
