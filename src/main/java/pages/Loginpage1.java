package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.WaitUtils;


public class Loginpage1 {

    private WebDriver driver;
    
    public Loginpage1(WebDriver driver) {
        this.driver = driver;
    }

    public void DriverStart() {
        // WebDriverManager.chromedriver().setup();
        // ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--width=1920");
        // chromeOptions.addArguments("--height=1080");
        // driver = new ChromeDriver(chromeOptions);
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--width=1920");
        firefoxOptions.addArguments("--height=1080");
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://trello.com");
        driver.manage().window().maximize();
    }

    // Locators
    private final By loginLink = By.xpath("(//a[text()='Log in'])[1]");
    private final By emailField = By.xpath("//input[@id='username-uid1']");
    private final By continueButton = By.xpath("//span[text()='Continue']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//span[text()='Log in']");


    public void clickLoginLink() {
   
        WebElement loginLinkElement = WaitUtils.waitForElementToBeClickable(driver, loginLink);
        loginLinkElement.click();
        WaitUtils.waitForPageToLoad(driver);
    }
    
   
     // Enter email address
    public void enterEmail(String email) {
        WebElement emailElement = WaitUtils.waitForElementToBeVisible(driver, emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }
    
    
     //Click continue button after entering email 
    public void clickContinue() {
        WebElement continueButtonElement = WaitUtils.waitForElementToBeClickable(driver, continueButton);
        continueButtonElement.click();
        WaitUtils.waitForPageToLoad(driver);
    }
    
  
     // Enter password
    public void enterPassword(String password) {
      
        WebElement passwordElement = WaitUtils.waitForElementToBeVisible(driver, passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    
    /**
     * Click login button to complete login
     */
    public void clickLogin() {
        
        WebElement loginButtonElement = WaitUtils.waitForElementToBeClickable(driver, loginButton);
        loginButtonElement.click();
        WaitUtils.waitForPageToLoad(driver);
    }
    
}
