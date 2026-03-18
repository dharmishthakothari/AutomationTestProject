package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Wikipedia1_wikipedia-search-input")
    private WebElement wikiInput;

    @FindBy(className = "wikipedia-search-button")
    private WebElement wikiSearchBtn;

    @FindBy(xpath = "//div[@id='wikipedia-search-result-link']/a")
    private List<WebElement> wikiSearchResults;

    @FindBy(xpath = "//button[contains(text(),'Copy Text')]")
    private WebElement btnDoubleClick;

    @FindBy(id = "field1")
    private WebElement field1;

    @FindBy(id = "field2")
    private WebElement field2;

    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    @FindBy(linkText = "Home")
    private WebElement linkHome;

    public void searchWikipedia(String query) {
        wikiInput.clear();
        wikiInput.sendKeys(query);
        wikiSearchBtn.click();
    }

    public int getSearchResultsCount() {
        return wikiSearchResults.size();
    }

    public void performDoubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(btnDoubleClick).perform();
    }

    public String getField2Text() {
        return field2.getAttribute("value");
    }

    public void performDragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public String getDroppableText() {
        return droppable.getText();
    }

    public void clickHomeLink() {
        linkHome.click();
    }

    public void switchToIframe(String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
