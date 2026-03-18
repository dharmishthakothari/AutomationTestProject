package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage {

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Static Web Table
    @FindBy(name = "BookTable")
    private WebElement staticTable;

    // Pagination Web Table
    @FindBy(id = "productTable")
    private WebElement paginationTable;

    @FindBy(xpath = "//ul[@id='pagination']/li/a")
    private List<WebElement> paginationLinks;

    public int getStaticTableRowsCount() {
        return staticTable.findElements(By.tagName("tr")).size();
    }

    public int getStaticTableColumnsCount() {
        return staticTable.findElements(By.xpath(".//tr[1]/th")).size();
    }

    public String getStaticTableCellValue(int row, int col) {
        return staticTable.findElement(By.xpath(".//tr[" + row + "]/td[" + col + "]")).getText();
    }

    public void selectPageInPagination(int pageNum) {
        for (WebElement link : paginationLinks) {
            if (link.getText().equals(String.valueOf(pageNum))) {
                link.click();
                break;
            }
        }
    }

    public int getPaginationTableRowsCount() {
        return paginationTable.findElements(By.xpath(".//tbody/tr")).size();
    }
}
