package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage {

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "phone")
    private WebElement inputPhone;

    @FindBy(id = "textarea")
    private WebElement inputAddress;

    @FindBy(id = "male")
    private WebElement radioMale;

    @FindBy(id = "female")
    private WebElement radioFemale;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@id,'day')]")
    private List<WebElement> checkboxesDays;

    @FindBy(id = "country")
    private WebElement dropdownCountry;

    @FindBy(id = "colors")
    private WebElement listboxColors;

    @FindBy(id = "datepicker")
    private WebElement datePicker;

    public void enterName(String name) { inputName.sendKeys(name); }
    public void enterEmail(String email) { inputEmail.sendKeys(email); }
    public void enterPhone(String phone) { inputPhone.sendKeys(phone); }
    public void enterAddress(String address) { inputAddress.sendKeys(address); }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) radioMale.click();
        else radioFemale.click();
    }

    public void selectDay(String day) {
        for (WebElement cb : checkboxesDays) {
            if (cb.getAttribute("value").equalsIgnoreCase(day)) {
                if (!cb.isSelected()) cb.click();
                break;
            }
        }
    }

    public void selectCountry(String country) {
        new Select(dropdownCountry).selectByVisibleText(country);
    }

    public void selectColor(String color) {
        new Select(listboxColors).selectByVisibleText(color);
    }

    public void selectDate(String date) {
        datePicker.sendKeys(date);
    }
}
