package com.epam.training.student_ulises_lara.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Abstract class representing a generic web page.
 * Provides common methods for interacting with web elements.
 */
public abstract class AbstractPage {

    /** WebDriver instance for interacting with the web browser */
    protected WebDriver driver;

    /** WebDriverWait instance for explicit waits */
    protected WebDriverWait wait;

    /** Timeout duration for waits in seconds */
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    /** Constructor initializing the WebDriver and WebDriverWait */
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

    /** Abstract method to open the specific page */
    protected abstract AbstractPage openPage();

    /** Waits for the visibility of a web element */
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /** Waits for a web element to be clickable */
    protected void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /** Clicks on a web element after waiting for it to be clickable */
    protected void clickElement(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    /** Types text into a web element after waiting for its visibility */
    protected void typeText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    /** Retrieves and trims the text from a web element after waiting for its visibility */
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText().trim();
    }
}
