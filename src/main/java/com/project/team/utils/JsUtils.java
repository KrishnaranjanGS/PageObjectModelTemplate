package com.project.team.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JsUtils {

	WebDriver driver;
	JavascriptExecutor js;

//	constructor:
	public JsUtils(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

//	Utilities:
	/**
	 * get page title using JS
	 */
	public String getTitleByJs() {
		return js.executeScript("return document.title;").toString();
	}

	/**
	 * This method returns WebElement.
	 */
	public WebElement getElementAndFlash(By locator) {
		WebElement element = driver.findElement(locator);
			if(Boolean.parseBoolean(com.project.team.factory.DriverFactory.highlight)) {
				flashElementByJS(element);
			}
	return element;
	}
	
	/**
	 * go to previous page using JS
	 */
	public void goBackByJs() {
		js.executeScript("history.go(-1);");
	}

	/**
	 * go to next page using JS
	 */
	public void goForwardByJs() {
		js.executeScript("history.go(1);");
	}

	/**
	 * refresh page using JS
	 */
	public void refreshBrowserByJs() {
		js.executeScript("history.go(0);");
	}

	/**
	 * Enter text in a textbox using element's 'id' attribute
	 * 
	 * @param id
	 * @param text
	 */
	public void sendKeysByJS(String id, String text) {
		String script = "document.getElementById('" + id + "').value='" + text + "';";
		js.executeScript(script);
	}

	/**
	 * Click on an element using JS
	 * 
	 * @param element
	 */
	public void clickByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * get the inner text of all elements in the page using JS
	 * 
	 * @return
	 */
	public String getPageInnerTextByJS() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	/**
	 * draw a border around the given element using JS
	 * 
	 * @param element
	 */
	public void drawBorderByJS(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * highlight the given element using JS
	 * 
	 * @param element
	 */
	public void flashElementByJS(WebElement element) {
		String bgColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 5; i++) {
			changeColor("rgb(0,100,0)", element);
			changeColor(bgColor, element);
		}
	}

	private void changeColor(String color, WebElement element) {
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * scroll to the bottom of page using JS
	 */
	public void scrollTopToBottomByJS() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	/**
	 * scroll to the top of the page
	 */
	public void scrollBottomToTopByJS() {
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}

	/**
	 * scroll down by given height
	 * 
	 * @param height
	 */
	public void scrollDownByJS(String height) {
		js.executeScript("window.scrollTo(0, '" + height + "');");
	}

	/**
	 * scroll to element
	 * 
	 * @param element
	 */
	public void scrollIntoViewByJS(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Wait till page loads (timeout value in millisec) using JS:
	 * 
	 * @param timeOut
	 */
	public void waitForPageLoad(int timeOut) {
		long endTime = System.currentTimeMillis() + timeOut;
		while (System.currentTimeMillis() < endTime) {
			String pageState = js.executeScript("return document.readyState").toString();
			if (pageState.equals("complete")) {
				System.out.println("page DOM is fully loaded now..");
				break;
			}
		}
	}

	/**
	 * Waits for JS alert in the page until given timeout
	 * 
	 * @param timeOut: timeout duration in seconds
	 * @return Alert
	 */
	public Alert waitForAlertPresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * return the text displayed in the JS alert
	 * 
	 * @param timeOut: timeout duration in seconds
	 * @return String: text in the alert
	 */
	public String getAlertText(int timeOut) {
		return waitForAlertPresent(timeOut).getText();
	}

	/**
	 * accept the JS alert
	 * 
	 * @param timeOut: timeout duration in seconds
	 */
	public void acceptAlert(int timeOut) {
		waitForAlertPresent(timeOut).accept();
	}

	/**
	 * dismiss the JS alert
	 * 
	 * @param timeOut: timeout duration in seconds
	 */
	public void dismissAlert(int timeOut) {
		waitForAlertPresent(timeOut).dismiss();
	}

	/**
	 * enter given value in the text box of the JS alert
	 * 
	 * @param timeOut: timeout duration in seconds
	 */
	public void alertSendKeys(String value, int timeOut) {
		waitForAlertPresent(timeOut).sendKeys(value);
	}
}
