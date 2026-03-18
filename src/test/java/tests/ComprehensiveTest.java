package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.FormPage;
import pages.HomePage;
import pages.TablePage;

@Listeners(utilities.TestListener.class)
public class ComprehensiveTest extends BaseTest {

    @Test(priority = 1, description = "Automate Form Details")
    public void testFormAutomation() {
        FormPage formPage = new FormPage(driver);
        logger.info("Filling form details...");
        formPage.enterName("Jane Doe");
        formPage.enterEmail("jane@test.com");
        formPage.enterPhone("9876543210");
        formPage.enterAddress("456 Elm St, CA");
        formPage.selectGender("female");
        formPage.selectDay("monday");
        formPage.selectDay("friday");
        formPage.selectCountry("Canada");
        formPage.selectColor("Red");
        logger.info("Form details filled.");
    }

    @Test(priority = 2, description = "Automate Date Picker")
    public void testDatePicker() {
        FormPage formPage = new FormPage(driver);
        logger.info("Selecting date...");
        formPage.selectDate("12/25/2024");
        logger.info("Date selected.");
    }

    @Test(priority = 3, description = "Automate Double Click Button")
    public void testDoubleClick() {
        HomePage homePage = new HomePage(driver);
        logger.info("Performing double click...");
        homePage.performDoubleClick();
        String result = homePage.getField2Text();
        Assert.assertEquals(result, "Hello World!", "Double click failed.");
        logger.info("Double click verified.");
    }

    @Test(priority = 4, description = "Automate Alerts")
    public void testAlerts() {
        AlertsPage alertsPage = new AlertsPage(driver);
        logger.info("Handling alert...");
        alertsPage.clickAlert();
        String alertText = alertsPage.getAlertTextAndAccept();
        Assert.assertEquals(alertText, "I am an alert box!", "Alert text mismatch.");

        logger.info("Handling confirmation alert...");
        alertsPage.clickConfirm();
        alertsPage.getAlertTextAndAccept();
        String confirmResult = alertsPage.getResultText();
        Assert.assertEquals(confirmResult, "You pressed OK!", "Confirmation failed.");
    }

    @Test(priority = 5, description = "Automate Web Table")
    public void testWebTable() {
        TablePage tablePage = new TablePage(driver);
        logger.info("Validating Static Web Table...");
        int rows = tablePage.getStaticTableRowsCount();
        int cols = tablePage.getStaticTableColumnsCount();
        logger.info("Rows: " + rows + ", Columns: " + cols);
        Assert.assertTrue(rows > 0, "Table rows should be greater than 0");
        
        String cellValue = tablePage.getStaticTableCellValue(2, 2); // Adjust index if needed (1-based or 0-based depends on xpath)
        logger.info("Cell Value at (2,2): " + cellValue);
        Assert.assertNotNull(cellValue, "Cell value should not be null");
    }

    @Test(priority = 6, description = "Automate Links")
    public void testLinks() {
        HomePage homePage = new HomePage(driver);
        logger.info("Clicking Home link...");
        homePage.clickHomeLink();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Practice"), "Navigation to Home failed.");
    }

    @Test(priority = 7, description = "Automate Drag and Drop")
    public void testDragAndDrop() {
        HomePage homePage = new HomePage(driver);
        logger.info("Performing drag and drop...");
        homePage.performDragAndDrop();
        String droppedText = homePage.getDroppableText();
        Assert.assertEquals(droppedText, "Dropped!", "Drag and drop failed.");
    }

    @Test(priority = 8, description = "Automate Iframe")
    public void testIframe() {
        HomePage homePage = new HomePage(driver);
        logger.info("Switching to iframe...");
        homePage.switchToIframe("frame-one761");
        // Inside iframe, search for elements or just verify presence
        logger.info("Switched to iframe successfully.");
        homePage.switchToDefaultContent();
    }
}
