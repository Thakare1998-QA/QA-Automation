package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtils;

public class MoveCards {
    private static WebDriver driver;
    
    // Locators
    private final By TCOO1 = By.xpath("//div[@data-card-id='688b614bb57440e8617bae1d']");
    private final By TCOO2 = By.xpath("//div[@data-card-id='688b614bdd9ff47ab0bcfb72']");
    private final By inProgressList = By.xpath("(//ol[@class='B27wN5INCjrQTV LcFnJFfQdwDOsP'])[2]");
    private final By doneList = By.xpath("(//ol[@class='B27wN5INCjrQTV LcFnJFfQdwDOsP'])[3]");
    
    
    // Method to set the driver
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
    
    public void moveCardToInProgress() {
        try {
            // Find the card in To Do list
            WebElement card = WaitUtils.waitForElementToBeVisible(driver, TCOO1);
            // Find the In Progress list
            WebElement targetList = WaitUtils.waitForElementToBeVisible(driver, inProgressList);  
            // Create Actions instance
            Actions actions = new Actions(driver);  
            // Perform drag and drop
            actions.clickAndHold(card)
                  .moveToElement(targetList)
                  .release()
                  .perform();
            
            // Wait for movement to complete
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.err.println("Failed to move card to In Progress: " + e.getMessage());
        }
    }
    
    public void moveCardToDone() {
        try {
            // Find the card in In Progress list
            WebElement card = driver.findElement(inProgressList).findElement(TCOO2);
            WebElement card1 = driver.findElement(inProgressList).findElement(TCOO1);
            // Find the Done list
            WebElement targetList = WaitUtils.waitForElementToBeVisible(driver, doneList);
            // Create Actions instance
            Actions actions = new Actions(driver); 
            // Perform drag and drop
            actions.clickAndHold(card)
                  .moveToElement(targetList)
                  .release()
                  .perform();

                  actions.clickAndHold(card1)
                  .moveToElement(targetList)
                  .release()
                  .perform();    
            
            // Wait for movement to complete
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.err.println("Failed to move card to Done: " + e.getMessage());
        }
    }
    

    
} 