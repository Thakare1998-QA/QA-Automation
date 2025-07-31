package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utils.WaitUtils;

public class AttachedPDF {



    private WebDriver driver;
    
    public AttachedPDF(WebDriver driver) {
        this.driver = driver;
    }

    // Click on card locators
    private final By clickOnCard1 = By.xpath("(//a[@data-testid='card-name'])[1]");   
    // Attached PDF locators
    private final By attachmentBtn = By.xpath("//span[(@data-testid='AttachmentIcon')]");
    private final By chooseFileBtn = By.xpath("//input[@type='file']");
    private final By closeBtn = By.xpath("//button[@class='y_p650fpIPDwsU ybVBgfOiuWZJtD Yt_v_LmarJM9ZS _St8_YSRMkLv07' and @aria-label='Close dialog']");
    
    // Method to set the driver
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }   

     //Upload PDF to Trello card    
    public void uploadPDFToCard() {
        try {
            // Get the absolute path to the PDF file
            File uploadFile = new File("src/test/resources/file-sample_150kB.pdf");
            
            if (!uploadFile.exists()) {
                System.err.println("PDF file not found at: " + uploadFile.getAbsolutePath());
                return;
            }           
            System.out.println("Starting PDF upload process...");
            System.out.println("   File path: " + uploadFile.getAbsolutePath());           
            // Step 1: Click on the first card
            WebElement cardElement = WaitUtils.waitForElementToBeClickable(driver, clickOnCard1);
            cardElement.click();
            
            // Step 2: Click on attachment button
            WebElement attachmentElement = WaitUtils.waitForElementToBeClickable(driver, attachmentBtn);
            attachmentElement.click();
            
            // Step 3: Select and upload file (uploads automatically after selection)
            WebElement fileInput = WaitUtils.waitForElementToBePresent(driver, chooseFileBtn);
            fileInput.sendKeys(uploadFile.getAbsolutePath());           
            // File uploads automatically after selection - no additional button click needed
            Thread.sleep(4000);

            System.out.println("PDF uploaded successfully!");

            // Step 4: Click on close button
            WebElement closeElement = WaitUtils.waitForElementToBeClickable(driver, closeBtn);
            closeElement.click();
            
        } catch (Exception e) {
            System.err.println("Error uploading PDF: " + e.getMessage());
          
        }
    }


    

}
