package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    private WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertBtn")
    private WebElement btnAlert;

    @FindBy(id = "confirmBtn")
    private WebElement btnConfirm;

    @FindBy(id = "promptBtn")
    private WebElement btnPrompt;

    @FindBy(id = "demo")
    private WebElement textResult;

    public void clickAlert() {
        btnAlert.click();
    }

    public void clickConfirm() {
        btnConfirm.click();
    }

    public void clickPrompt() {
        btnPrompt.click();
    }

    public String getAlertTextAndAccept() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void typeInPromptAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        return textResult.getText();
    }
}
