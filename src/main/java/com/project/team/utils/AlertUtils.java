package com.project.team.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertUtils {

	WebDriver driver;
	WaitUtils waitUtils;
	
//	constructor:
	public AlertUtils(WebDriver driver) {
		this.driver = driver;
		
	}
	
//	Utilities:
	/**
	 * Waits for an alert and returns the alert.
	 * @param timeOut
	 * @return Alert
	 */
	public Alert waitForAlertPresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * Get the text from and alert.
	 * @param timeOut
	 * @return String
	 */
	public String getAlertText(int timeOut) {
		return waitForAlertPresent(timeOut).getText();
	}
	
	/**
	 * Accept an alert. This closes the alert.
	 * @param timeOut
	 */
	public void acceptAlert(int timeOut) {
		waitForAlertPresent(timeOut).accept();
	}
	
	/**
	 * Dismisses an alert. This closes the alert.
	 * @param timeOut
	 */
	public void dismissAlert(int timeOut) {
		waitForAlertPresent(timeOut).dismiss();
	}
	
	/**
	 * Enters given string in the alert text box.
	 * @param value
	 * @param timeOut
	 */
	public void alertSendKeys(String value, int timeOut) {
		waitForAlertPresent(timeOut).sendKeys(value);
	}
	
	
}
