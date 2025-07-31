package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class CreateCards {

    private WebDriver driver;
    
    public CreateCards(WebDriver driver) {
        this.driver = driver;
    }
    
    // Method to set the driver
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }


   //add list and enter List Name locaters
    //private final By addListButton = By.xpath("//button[@data-testid='list-composer-button']");
    private final By EnterListName1 = By.xpath("//textarea[@data-testid='list-name-textarea']");
    private final By EnterListName2 = By.xpath("(//textarea[@data-testid='list-name-textarea'])[2]");
    private final By EnterListName3 = By.xpath("(//textarea[@data-testid='list-name-textarea'])[3]");
    private final By createListbtn = By.xpath("//button[@data-testid='list-composer-add-list-button']");

    //add card to Created List and enter Title to card 
    private final By addCardinToDO = By.xpath("(//button[@data-testid='list-add-card-button'])[1]");
    private final By EnterCardTitle = By.xpath("//textarea[@data-testid='list-card-composer-textarea']");
    private final By ClickAddCardBtn = By.xpath("//button[@data-testid='list-card-composer-add-card-button']");
    
    //add card to Created List and enter Title to card
    private final By addCardInProgress = By.xpath("(//button[@data-testid='list-add-card-button' and @aria-label='Add a card in In Progress'])");
    //add card to Created List and enter title to card.
    private final By addCardinDone = By.xpath("(//button[@data-testid='list-add-card-button' and @aria-label='Add a card in Done'])");
    //click on card locaters
    private final By ClickonCard1 = By.xpath("(//a[@data-testid='card-name'])[1]");
    private final By ClickonCard2 = By.xpath("(//a[@data-testid='card-name'])[2]");
    private final By ClickonCard3 = By.xpath("(//a[@data-testid='card-name'])[3]");
    //add lable locaters
    private final By LablesBtn= By.xpath("//span[@data-testid='LabelIcon']");  
    private final By ToDoLableRed= By.xpath("//span[@data-testid='card-label' and @data-color='red']");
    private final By InProgressLableBlue= By.xpath("//span[@data-testid='card-label' and @data-color='blue']");  
    private final By DoneLableGreen= By.xpath("//span[@data-testid='card-label' and @data-color='green']");
    private final By CloseLables= By.xpath("//button[@class='JABNldlIncwKgc zrn4tJQdoA76rj' and @aria-label='Close popover']");

   //add discription locaters
   private final By DiscriptionBtn= By.xpath("//button[@data-testid='description-button']");
   private final By EnterDiscription= By.xpath("//div[@id='ak-editor-textarea' and @aria-label='Description']");
   private final By SaveDiscriptionBtn= By.xpath("//button[@data-testid='description-save-button']");
   private final By CloseDiscripction = By.xpath("//span[@data-testid='CloseIcon' and @data-vc='icon-CloseIcon']");




   public void AddList() {
    // WebElement addListButtonElement = WaitUtils.waitForElementToBeVisible(driver, addListButton);
    // addListButtonElement.click();
    WebElement enterListName1Element = WaitUtils.waitForElementToBeVisible(driver, EnterListName1);
    enterListName1Element.sendKeys("To Do");
    WebElement createListbtnElement = WaitUtils.waitForElementToBeVisible(driver, createListbtn);
    createListbtnElement.click();

    //add List2 and enter List Name
    // WebElement addListButtonElement2 = WaitUtils.waitForElementToBeVisible(driver, addListButton);
    // addListButtonElement2.click();
    WebElement enterListName2Element = WaitUtils.waitForElementToBeVisible(driver, EnterListName2);
    enterListName2Element.sendKeys("In Progress");
    WebElement createListbtnElement2 = WaitUtils.waitForElementToBeVisible(driver, createListbtn);
    createListbtnElement2.click();

    //add List3 and enter List Name
    // WebElement addListButtonElement3 = WaitUtils.waitForElementToBeVisible(driver, addListButton);
    // addListButtonElement3.click();
    WebElement enterListName3Element = WaitUtils.waitForElementToBeVisible(driver, EnterListName3);
    enterListName3Element.sendKeys("Done");
    WebElement createListbtnElement3 = WaitUtils.waitForElementToBeVisible(driver, createListbtn);
    createListbtnElement3.click();
   
   }

   public void AddCard() {

    //add card to To Do List and enter Title to card and click on add card button
    WebElement addCardinToDOElement = WaitUtils.waitForElementToBeVisible(driver, addCardinToDO);
    addCardinToDOElement.click();
    WebElement EnterCardTitleElement = WaitUtils.waitForElementToBeVisible(driver, EnterCardTitle);
    EnterCardTitleElement.sendKeys("Login Test Case - 001");
    WebElement ClickAddCardBtn1 = WaitUtils.waitForElementToBeVisible(driver, ClickAddCardBtn);
    ClickAddCardBtn1.click();

    //add card to In Progress List and enter Title to card and click on add card button
    WebElement addCardInProgressElement = WaitUtils.waitForElementToBeVisible(driver, addCardInProgress);
    addCardInProgressElement.click();
    WebElement EnterCardTitleElement2 = WaitUtils.waitForElementToBeVisible(driver, EnterCardTitle);
    EnterCardTitleElement2.sendKeys("Login Test Case - 002");
    WebElement ClickAddCardBtn2 = WaitUtils.waitForElementToBeVisible(driver, ClickAddCardBtn);
    ClickAddCardBtn2.click();

    //add card to Done List and enter Title to card and click on add card button
    WebElement addCardinDoneElement = WaitUtils.waitForElementToBeVisible(driver, addCardinDone);
    addCardinDoneElement.click();
    WebElement EnterCardTitleElement3 = WaitUtils.waitForElementToBeVisible(driver, EnterCardTitle);
    EnterCardTitleElement3.sendKeys("Login Test Case - 003");
    WebElement ClickAddCardBtn3 = WaitUtils.waitForElementToBeVisible(driver, ClickAddCardBtn);
    ClickAddCardBtn3.click();

    
   }

   public void AddLablesAllCards(){

    String toDoDescription = "Verify that users can successfully log in using a valid email address and correct password. "
        + "This test case ensures the core functionality of the email/password authentication flow is working as expected.";

    String InProgressDescription = "Attempt to log in using an incorrectly formatted email address." 
                    +"Verify that the system properly validates the email format and displays an appropriate error message without allowing the login. ";

    String DoneDescription = "Try to log in using an email address that is not registered in the system." 
            +"Ensure that the application handles this scenario securely by not revealing whether the email exists and displaying a generic error message."; 
      
      
     //click on card1
    WebElement ClickonCard1Element = WaitUtils.waitForElementToBeVisible(driver, ClickonCard1);
    ClickonCard1Element.click();
    //add lable to card1
    WebElement ClickonLablesBtnElement = WaitUtils.waitForElementToBeVisible(driver, LablesBtn);
    ClickonLablesBtnElement.click();
    WebElement ClickonToDoLableRedElement = WaitUtils.waitForElementToBeVisible(driver, ToDoLableRed);
    ClickonToDoLableRedElement.click();
    WebElement CloseLablesElement = WaitUtils.waitForElementToBeVisible(driver, CloseLables);
    CloseLablesElement.click();
    //add discription to card1
    //add discription to card12
    WebElement ClickonDiscriptionBtnElement = WaitUtils.waitForElementToBeVisible(driver, DiscriptionBtn);
    ClickonDiscriptionBtnElement.click();
    WebElement EnterDiscriptionElement = WaitUtils.waitForElementToBeVisible(driver, EnterDiscription);
    EnterDiscriptionElement.sendKeys(toDoDescription);
    WebElement SaveDiscriptionBtnElement = WaitUtils.waitForElementToBeVisible(driver, SaveDiscriptionBtn);
    SaveDiscriptionBtnElement.click();
    //close discription
    WebElement CloseDiscripctionElement = WaitUtils.waitForElementToBeVisible(driver, CloseDiscripction);
    CloseDiscripctionElement.click();




    //click on card2
    WebElement ClickonCard2Element = WaitUtils.waitForElementToBeVisible(driver, ClickonCard2);
    ClickonCard2Element.click();
    //add lable to card
    WebElement ClickonLablesBtnElement2 = WaitUtils.waitForElementToBeVisible(driver, LablesBtn);
    ClickonLablesBtnElement2.click();
    //In Progress Lable Blue
    WebElement ClickonInProgressLableBlueElement = WaitUtils.waitForElementToBeVisible(driver, InProgressLableBlue);
    ClickonInProgressLableBlueElement.click();
    WebElement CloseLablesElement2 = WaitUtils.waitForElementToBeVisible(driver, CloseLables);
    CloseLablesElement2.click();
    //add discription to card2
    WebElement ClickonDiscriptionBtnElement2 = WaitUtils.waitForElementToBeVisible(driver, DiscriptionBtn);
    ClickonDiscriptionBtnElement2.click();
    WebElement EnterDiscriptionElement2 = WaitUtils.waitForElementToBeVisible(driver, EnterDiscription);
    EnterDiscriptionElement2.sendKeys(InProgressDescription);
    WebElement SaveDiscriptionBtnElement2 = WaitUtils.waitForElementToBeVisible(driver, SaveDiscriptionBtn);
    SaveDiscriptionBtnElement2.click();
    //close discription2
    WebElement CloseDiscripctionElement2 = WaitUtils.waitForElementToBeVisible(driver, CloseDiscripction);
    CloseDiscripctionElement2.click();

    //click on card3
    WebElement ClickonCard3Element = WaitUtils.waitForElementToBeVisible(driver, ClickonCard3);
    ClickonCard3Element.click();
    //add lable to card3
    WebElement ClickonLablesBtnElement3 = WaitUtils.waitForElementToBeVisible(driver, LablesBtn);
    ClickonLablesBtnElement3.click();
    //Done Lable Green  
    WebElement ClickonDoneLableGreenElement = WaitUtils.waitForElementToBeVisible(driver, DoneLableGreen);
    ClickonDoneLableGreenElement.click();
    WebElement CloseLablesElement3 = WaitUtils.waitForElementToBeVisible(driver, CloseLables);
    CloseLablesElement3.click();
    //add discription to card3
    WebElement ClickonDiscriptionBtnElement3 = WaitUtils.waitForElementToBeVisible(driver, DiscriptionBtn);
    ClickonDiscriptionBtnElement3.click();
    WebElement EnterDiscriptionElement3 = WaitUtils.waitForElementToBeVisible(driver, EnterDiscription);
    EnterDiscriptionElement3.sendKeys(DoneDescription);
    WebElement SaveDiscriptionBtnElement3 = WaitUtils.waitForElementToBeVisible(driver, SaveDiscriptionBtn);
    SaveDiscriptionBtnElement3.click();

    //close discription
    WebElement CloseDiscripctionElement3 = WaitUtils.waitForElementToBeVisible(driver, CloseDiscripction);
    CloseDiscripctionElement3.click();
   }

}
