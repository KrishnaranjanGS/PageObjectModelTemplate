package com.project.team.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	private WebDriver driver;

//	Constructor:
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

//	Utilities:
	/**
	 * get page title
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("page title: " + pageTitle);
		return pageTitle;
	}

	/**
	 * get the page URL
	 * 
	 * @return page URL as String
	 */
	public String getPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println("page URL: " + pageUrl);
		return pageUrl;
	}

	/**
	 * get the WebElement using the given locator
	 * 
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * get the list of web elements from the given locator
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * enter given value in the WebElement
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * click on the given element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * get text from the given element
	 * 
	 * @param locator
	 * @return String
	 */
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	/**
	 * check if the given element is displayed and return true/false
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	/**
	 * selects a value in the drop down based on given index
	 * 
	 * @param locator
	 * @param index
	 */
	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	/**
	 * selects a value in the drop down based on given value.
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	/**
	 * selects a value in the drop down based on given visible text.
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSelectDropDownByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	/**
	 * returns a list of WebElements from a drop down list.
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElement> doGetDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	/**
	 * returns the count of elements in a drop down list. Returns an integer value.
	 * 
	 * @param locator
	 * @return int
	 */
	public int doGetDropDownOptionsCount(By locator) {
		int optionsCount = doGetDropDownOptionsList(locator).size();
		System.out.println("Number of elements in drop down list: " + optionsCount);
		return optionsCount;
	}

	/**
	 * returns the text of each element in a drop down list.
	 * 
	 * @param locator
	 * @return List<String>
	 */
	public List<String> getDropDownOptionsTextList(By locator) {
		List<WebElement> optionsList = doGetDropDownOptionsList(locator);
		List<String> optionsTextList = new ArrayList();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	/**
	 * select given element from the drop down list.
	 * 
	 * @param locator
	 * @param expValue (exact text)
	 */
	public void doSelectDropDownValue(By locator, String expValue) {
		List<WebElement> optionsList = doGetDropDownOptionsList(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(expValue)) {
				e.click();
				break;
			}
		}
	}

	/**
	 * get list of results in free text search suggestions and select one which
	 * contains given value
	 * 
	 * @param locator
	 * @param value   (lower case)
	 */
	public void doGetFTSsuggestionList(By locator, String value) {
		List<WebElement> suggestionsList = doGetElements(locator);
		System.out.println("No. of elements in FTS suggestion list: " + suggestionsList.size());
		for (WebElement e : suggestionsList) {
			String text = e.getText();
			if (text.length() > 0) {
				System.out.println(text);
			}
			if (e.getText().toLowerCase().contains(value)) {
				e.click();
				break;
			}
		}
	}

	/**
	 * Note the windowsHandle, click on link to open new window, switch to new
	 * window. Returns original window handle.
	 * 
	 * @param locator
	 * @param parentWindowHandle (optional. If not provided, method will get the
	 *                           window handle before clicking on the link to new
	 *                           window)
	 * @return String
	 */
	public String doSwitchToNewWindow(By locator, String parentWindowHandle) {
		String originalWindowHandle;
		if (parentWindowHandle == null) {
			originalWindowHandle = driver.getWindowHandle();
		} else {
			originalWindowHandle = parentWindowHandle;
		}
		System.out.println("Parent window handle: " + originalWindowHandle);
		WebElement element = getElement(locator);
		element.click();
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		for (String str : windowHandles) {
			System.out.println("Checking window handle " + str + "with " + originalWindowHandle);
			if (!(str.equals(originalWindowHandle))) {
				System.out.println("Found new window handle " + str + ". Switching to new window/tab.");
				driver.switchTo().window(str);
			}
		}
		return originalWindowHandle;
	}

	/**
	 * This method works only if pagination has next and previous buttons.
	 * Based on the clickOption value, previous or next button will be clicked.
	 * @param previousBtn
	 * @param nextBtn
	 * @param clickOption
	 */
	public void doClickPagination(By previousBtn, By nextBtn, String clickOption) {
		WebElement prevBtn = driver.findElement(nextBtn);
		WebElement nxtBtn = driver.findElement(nextBtn);
		switch (clickOption.trim().toLowerCase()) {
		case "previous":
			if (prevBtn.isEnabled()) {
				prevBtn.click();
			} else {
				System.out.println("Previous button is disabled.");
			}
			break;
		case "next":
			if (nxtBtn.isEnabled()) {
				nxtBtn.click();
			} else {
				System.out.println("Next button is disabled.");
			}
			break;
		default:
			System.out.println("Invalid option: " + clickOption + ". Valid options are: previous, next.");
			break;
		}
	}
	
}
