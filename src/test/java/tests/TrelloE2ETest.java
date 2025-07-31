package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AttachedPDF;
import pages.CreateBoard;
import pages.CreateCards;
import pages.Loginpage1;
import pages.MoveCards;
import utils.TestConfig;
@Test(groups = "e2e")
public class TrelloE2ETest {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Parameters({"browser", "headless"})
    @BeforeTest
    public void setup(@Optional("firefox") String browser, @Optional("false") String headless) {
        test = extent.createTest("Trello E2E Test", "Testing Trello board creation and card management");
        
        // Setup WebDriver based on parameters
        switch(browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(Boolean.parseBoolean(headless)) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--width=1920");
                chromeOptions.addArguments("--height=1080");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                if(Boolean.parseBoolean(headless)) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
        
        driver.manage().window().maximize();
        
        // Driver will be passed to page objects when created
        
        test.log(Status.INFO, "Browser started successfully: " + browser + (Boolean.parseBoolean(headless) ? " (headless)" : ""));
    }

    @Test(groups = "e2e")
    public void trelloE2ETest() {
        try {
            // Navigate to Trello
            driver.get("https://trello.com/");
            test.log(Status.INFO, "Navigated to Trello homepage");
            
            // Initialize page objects with driver
            Loginpage1 loginPage = new Loginpage1(driver);
            
            // Login
            test.log(Status.INFO, "Starting login process");
            loginPage.clickLoginLink();
            loginPage.enterEmail(TestConfig.getTrelloEmail());
            loginPage.clickContinue();
            loginPage.enterPassword(TestConfig.getTrelloPassword());
            loginPage.clickLogin();
            test.log(Status.PASS, "Login successful");

            // Create board and lists
            CreateBoard createBoard = new CreateBoard(driver);

            createBoard.ClickCreateBtn();
            createBoard.ClickCreateBoardBtn();
            createBoard.EnterBoardTitle("QA Scrum Board");
            createBoard.ClickCreateBoard();
            test.log(Status.INFO, "Creating board and lists");
            CreateCards createCards = new CreateCards(driver);
            createCards.AddList();
            test.log(Status.PASS, "Lists created successfully");

            // Add cards with labels and descriptions
            test.log(Status.INFO, "Adding cards with labels and descriptions");
            createCards.AddCard();
            createCards.AddLablesAllCards();
            test.log(Status.PASS, "Cards added with labels and descriptions");

            // Add PDF attachment
            test.log(Status.INFO, "Adding PDF attachment");
            AttachedPDF attachPDF = new AttachedPDF(driver);
            attachPDF.uploadPDFToCard();
            test.log(Status.PASS, "PDF attached successfully");

            // Move cards across lists
            test.log(Status.INFO, "Moving cards between lists");
            MoveCards moveCards = new MoveCards();
            moveCards.setDriver(driver);
            
            moveCards.moveCardToInProgress();
            test.log(Status.INFO, "Card moved to In Progress");
            
            moveCards.moveCardToDone();
            test.log(Status.INFO, "Card moved to Done");
            

            test.log(Status.PASS, "All test steps completed successfully");

        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed with exception: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            test.log(Status.INFO, "Browser closed");
        }
    }

    @AfterSuite
    public void cleanup() {
        extent.flush();
    }
} 