package com.urbuddi.base;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.OffsetMapping.Target;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.scheduling.SerenityFluentWait;

public class BasePage extends PageObject {
	public WebElementFacade getElement(String locator) {

		try {

			return find(getBy(locator));

		} catch (NoSuchElementException e) {

			e.getMessage();

		}

		return null;
	}

	// Finding Multiple Elements
	public List<WebElementFacade> getElements(String locator) {

		try {

			return findAll(getBy(locator));

		} catch (NoSuchElementException e) {

			e.getMessage();

		}

		return null;
	}

	private By getBy(String locator) {

		By by = null;

		try {

			if (locator.startsWith("id=")) {

				locator = locator.substring(3);
				by = By.id(locator);
			} else if (locator.startsWith("xpath=")) {

				locator = locator.substring(6);
				by = By.xpath(locator);
			} else if (locator.startsWith("css=")) {

				locator = locator.substring(4);
				by = By.cssSelector(locator);
			} else if (locator.startsWith("name=")) {

				locator = locator.substring(5);
				by = By.name(locator);
			} else if (locator.startsWith("link=")) {

				locator = locator.substring(5);
				by = By.linkText(locator);
			}
			return by;

		} catch (Throwable t) {

			t.getMessage();
		}

		return null;

	}

	public void type(String locator, String value) {
		elementPresence(locator);
		waitFor(getElement(locator)).sendKeys(value);
	}

	public void click(String locator) {
		waitFor(getElement(locator)).waitUntilClickable();
		waitFor(getElement(locator)).click();
	}

	public String getText(String locator) {
		return waitFor(getElement(locator)).getText();
	}

	public void moveMouseTo(String locator) {
		WebElement moveTo = waitFor(getElement(locator));
		withAction().moveToElement(moveTo).perform();
	}

	public void elementPresence(String locator) {
		waitFor(getElement(locator)).shouldBePresent();
		Assert.assertEquals(locator, locator);
	}

	public void fileUpload(String locator, String filepath) {
		WebElementFacade fileInput = getElement(locator);
		File fileToUpload = new File(filepath);
		fileInput.sendKeys(fileToUpload.getAbsolutePath());

	}

	public void hoverOnElement(String locator) {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(getElement(locator)).perform();
	}

	public String getElementText(String locator) {
		String text = waitFor(getElement(locator)).getText();
		return text;
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public boolean getAttributeContainsText(String locator, String attribute, String text) {
		String attributeValue = waitFor(getElement(locator)).getAttribute(attribute);
		System.out.println(attributeValue);
		boolean elementText = attributeValue != null && attributeValue.contains(text);
		System.out.println(elementText);
		return elementText;
	}

	public void verifyElementContainsText(String locator, String expectedText) {
		waitFor(getElement(locator)).shouldContainText(expectedText);
	}

	public void elementVisible(String locator) {
		waitFor(getElement(locator)).shouldBeVisible();
	}

	public void elementNotPresence(String locator) {
		waitFor(getElement(locator)).shouldNotBePresent();
	}

	public void uploadFile(String filePath) {
		WebElement fileInput = find(By.xpath(filePath)); // Replace with the actual locator of the file input field
		fileInput.sendKeys(filePath);
	}

	public void zoomIn() {
		WebDriver driver = getDriver();
		double zoomLevel = 1.2;
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '" + zoomLevel + "';");
	}

	public void zoomOut() {
		WebDriver driver = getDriver();
		double zoomLevel = 0.75;
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '" + zoomLevel + "';");
	}

	public void clickElementWithJavaScript(String locater) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", waitFor(getElement(locater)));
	}

	public boolean isElementVisible(String locator) {
		try {
			return $(locator).isVisible();
		} catch (ElementNotVisibleException | NoSuchElementException e) {
			return false;
		}
	}

	public void selectByValue(String locator, String value) {
		Select dropdown = new Select(waitFor(getElement(locator)));
		dropdown.selectByValue(value);
	}
}
