package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.WaitUtils;

public class CreateBoard {

    private WebDriver driver;

    public CreateBoard(WebDriver driver) {
        this.driver = driver;
    }

   // Locators
    private final By CreateBtn = By.xpath("//p[text()='Create']");
   // private final By CreatenewBtn = By.xpath("//button[@data-testid='create-board-tile']");
    private final By CreateBoardBtn = By.xpath("//button[@class='LOhIKSjx1ImXEH' and @data-testid='header-create-board-button']");
    private final By BoardTitle = By.xpath("//input[@class='nch-textfield__input a3omnNx_j558kc a3omnNx_j558kc CnTZlKrUqfJz6J']");
    private final By CreateBoard = By.xpath("//button[@data-testid='create-board-submit-button']");
  
  
    public void ClickCreateBtn() {
        
        WebElement createBtn = WaitUtils.waitForElementToBeClickable(driver, CreateBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(createBtn).click().perform();
       // createBtn.click();
    }

    public void ClickCreateBoardBtn() {
        WebElement createBoardBtn = WaitUtils.waitForElementToBeClickable(driver, CreateBoardBtn);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(createBoardBtn).click().perform();
        
        //createBoardBtn.click();
    }

    public void EnterBoardTitle(String boardTitle) {
        // unique board name with timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd(HH.mm)"));
        String initials = "DT"; // You can change this to your initials
        String boardtitle = String.format("QA Scrum Board - %s - %s", initials, timestamp);

        WebElement boardTitleBy = WaitUtils.waitForElementToBeVisible(driver, BoardTitle);
        boardTitleBy.sendKeys(boardtitle);
    }

    public void ClickCreateBoard() {
        WebElement createBoard = WaitUtils.waitForElementToBeClickable(driver, CreateBoard);
        createBoard.click();
      
    }

}
