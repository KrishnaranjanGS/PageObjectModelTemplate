package com.project.team.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

	WebDriver driver;
	WaitUtils waitUtils;
	JsUtils jsUtils;
	ElementUtils eleUtils;
	Actions act;

	public ActionsUtils(WebDriver driver) {
		this.driver = driver;
		waitUtils = new WaitUtils(driver);
		jsUtils = new JsUtils(driver);
		eleUtils = new ElementUtils(driver);
		act = new Actions(driver);
	}

	/**
	 * Enter text in a textbox using Actions class send keys
	 * 
	 * @param locator
	 * @param value
	 */
	public void doActionsSendKeys(By locator, String value) {
		act.sendKeys(eleUtils.getElement(locator)).build().perform();
	}

	/**
	 * move to element using actions. This is a mouse over action
	 * class click
	 * 
	 * @param locator: By locator of the element
	 * @param timeOut: timeout duration in seconds
	 */
	public void moveToElementWithActions(By locator, int timeOut) {
		WebElement element = eleUtils.getElement(locator);
		act.moveToElement(element).build().perform();
	}

	/**
	 * click on an element using actions
	 * class click
	 * 
	 * @param locator: By locator of the element
	 * @param timeOut: timeout duration in seconds
	 */
	public void elementClickWithActions(By locator, int timeOut) {
		WebElement element = eleUtils.getElement(locator);
		act.click(element).build().perform();
	}

	/**
	 * click and hold an element, drag and drop it at given locator
	 * @param locatorDrag
	 * @param locatorDrop
	 */
	public void dragAndDropElementWithActions(By locatorDrag, By locatorDrop) {
		WebElement drag = eleUtils.getElement(locatorDrag);
		WebElement drop = eleUtils.getElement(locatorDrop);
		act.clickAndHold(drag).moveToElement(drop).release().build().perform();
	}
	
	
	public void rightClickElement(By locator) {
		WebElement contextBtn = eleUtils.getElement(locator);
		act.contextClick(contextBtn).build().perform();
	}
	

}
