# Trello UI Automation Test Suite
A comprehensive Selenium UI automation test suite for Trello using Java, TestNG, and Page Object Model.
# Prerequisites
- Java 11 or higher
- Maven 3.6+
- Firefox browser (latest version)
- TestNG plugin in your IDE (if running from IDE)

## Project Structure
src/
├── main/java/
│   ├── pages/                    # Page Object Model classes
│   │   ├── Loginpage1.java      # Login functionality
│   │   ├── CreateCards.java     # Create lists and cards
│   │   ├── AttachedPDF.java     # PDF attachment functionality
│   │   └── MoveCards.java       # Drag and drop functionality
│   └── utils/                    # Utility classes
│       ├── ConfigReader.java     # Configuration reader
│       └── WaitUtils.java       # Explicit wait utilities
└── test/
    ├── java/tests/              # Test classes
    │   └── TrelloE2ETest.java   # Main test suite
    └── resources/               # Test resources
        └── Dnyneshwar Thakare CV NEW.pdf  # Sample PDF for attachment

test-output/                     # Generated test reports
└── ExtentReport.html           # Detailed HTML test report
```

## Running Tests

### 1. Using IDE (Recommended)

#### IntelliJ IDEA:
1. Right-click on `testng.xml`
2. Select "Run 'testng.xml'"

#### Eclipse:
1. Right-click on `testng.xml`
2. Select "Run As" → "TestNG Suite"

### 2. Using Maven Command Line:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### 3. Running Specific Test:
```bash
mvn test -Dtest=TrelloE2ETest
```

## Test Flow

1. **Login** (`Loginpage1.java`)
   - Navigate to Trello
   - Login with credentials

2. **Create Lists** (`CreateCards.java`)
   - Create "To Do", "In Progress", "Done" lists
   - Add cards to each list
   - Add labels and descriptions

3. **Attach PDF** (`AttachedPDF.java`)
   - Upload PDF to first card
   - Verify attachment

4. **Move Cards** (`MoveCards.java`)
   - Drag cards between lists
   - Move from To Do → In Progress → Done

## Test Reports

### Location:
- `test-output/ExtentReport.html` - Detailed test execution report
- `test-output/emailable-report.html` - TestNG summary report

### Report Contents:
- Test execution status
- Step-by-step logs
- Screenshots (on failure)
- Execution time
- Test suite summary

## Key Features

**Page Object Model**
- Separate class for each page
- Maintainable locators
- Reusable methods

 **Explicit Waits**
- No Thread.sleep()
- Dynamic element waiting
- Custom wait utilities

**Logging**
- Detailed step logs
- Error handling
- ExtentReports integration

 **Cross-browser Support**
- Firefox (default)
- Chrome (configurable)

## Common Issues & Solutions

### 1. Element Not Found
- Check if the page is fully loaded
- Verify locators are correct
- Increase wait timeout in `WaitUtils.java`

### 2. Test Execution Failed
- Ensure Firefox is installed
- Check if TestNG plugin is installed in IDE
- Verify `testng.xml` configuration

### 3. Report Not Generated
- Check write permissions in test-output directory
- Ensure ExtentReports dependency in pom.xml
- Run with `mvn clean test` to refresh

## Best Practices

1. **Before Running Tests:**
   - Close all Firefox instances
   - Clear browser cache
   - Update Firefox to latest version

2. **Maintaining Tests:**
   - Update locators if Trello UI changes
   - Keep PDF file path updated
   - Maintain unique card names

3. **Debugging:**
   - Check ExtentReport for detailed logs
   - Use explicit waits appropriately
   - Verify element locators

## Support

For issues or questions:
1. Check common issues section
2. Verify prerequisites
3. Review test logs in ExtentReport
4. Update Firefox and WebDriver 