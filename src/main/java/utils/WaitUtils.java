package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Utility class for managing waits and common wait operations
 */
public class WaitUtils {
    private static final Logger logger = LoggerFactory.getLogger(WaitUtils.class);
    private static final int DEFAULT_TIMEOUT = 40;
    
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        logger.debug("Waiting for element to be visible: {}", locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
     // Wait for element to be visible with default timeout
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return waitForElementToBeVisible(driver, locator, DEFAULT_TIMEOUT);
    }
     //Wait for element to be clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        logger.debug("Waiting for element to be clickable: {}", locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
     // Wait for element to be clickable with default timeout
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, DEFAULT_TIMEOUT);
    }
     // Wait for element to be present in DOM
    public static WebElement waitForElementToBePresent(WebDriver driver, By locator, int timeoutInSeconds) {
        logger.debug("Waiting for element to be present: {}", locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
     //Wait for element to be present with default timeout  
    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        return waitForElementToBePresent(driver, locator, DEFAULT_TIMEOUT);
    }

     //Wait for page to load completely
    
    public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        logger.debug("Waiting for page to load");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
     // Wait for page to load with default timeout
    
    public static void waitForPageToLoad(WebDriver driver) {
        waitForPageToLoad(driver, DEFAULT_TIMEOUT);
    }
    
} 