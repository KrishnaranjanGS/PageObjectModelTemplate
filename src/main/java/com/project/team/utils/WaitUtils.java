package com.project.team.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Checks that an element is present on the DOM of a page and returns the
	 * element. If element is present in DOM but not seen in UI, this method won't
	 * work.
	 * 
	 * @param locator:  By locator
	 * @param duration: timeout duration in seconds
	 * @return WebElement: WebElement from the given By locator
	 */
	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Checks that an element is present on the DOM of a page and visible in the UI.
	 * Visibility means that the element is not only displayed but also has a height
	 * and width that is greater than 0.
	 * 
	 * @param locator:  By locator
	 * @param duration: timeout duration in seconds
	 * @return WebElement: WebElement from the given By locator
	 */
	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * wait for the list of webElements to be visible on page
	 * 
	 * @param locator: By locator
	 * @param timeOut: timeout duration in seconds
	 * @return List<WebElement>: list of WebElements from the by given locator
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * wait for the element to be visible and enabled and return the element
	 * 
	 * @param Locator: By locator of the clickable element
	 * @param timeOut: timeout duration in seconds
	 * @return WebElement: WebElement from the given By locator
	 */
	public WebElement waitForElementToBeClickable(By Locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}

	/**
	 * wait for the frame to load and switch to it
	 * 
	 * @param idOrName: attribute value of id or name of the frame
	 * @param timeOut:  timeout duration in seconds
	 */
	public void waitForFrameAndSwitchToItByIdOrName(String idOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}

	/**
	 * wait for the frame to load and switch to it
	 * 
	 * @param frameIndex: index value of the frame
	 * @param timeOut:    timeout duration in seconds
	 */
	public void waitForFrameAndSwitchToItByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	/**
	 * wait for the frame to load and switch to it
	 * 
	 * @param frameElement: WebElement of the frame
	 * @param timeOut:      timeout duration in seconds
	 */
	public void waitForFrameAndSwitchToItByFrameElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	/**
	 * wait for the frame to load and switch to it
	 * 
	 * @param frameLocator: By locator of the frame
	 * @param timeOut:      timeout duration in seconds
	 */
	public void waitForFrameAndSwitchToItByFrameLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
}
