package pages.checkboxes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import java.util.List;

public class CheckBoxesPage extends BasePage {
    @FindBy(xpath = "//label[text()='Select the languages that you know?']/following-sibling::input")
    private WebElement languagesCheckBox;

    @FindBy(xpath = "//label[text()='Confirm Selenium is checked']/following-sibling::input")
    private WebElement confirmSeleniumCheckBox;

    @FindBy(xpath = "//label[text()='DeSelect only checked']/following-sibling::input[2]")
    private WebElement deSelectOnlyCheckBoxSelectOnlyCheckBox;

    @FindBy(xpath = "//label[text()='Select all below checkboxes ']/following-sibling::input")
    private List<WebElement> selectAllBelowCheckBox;

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/checkbox.html";
    }

    public Boolean languagesCheckBox(){
        languagesCheckBox.click();
        return languagesCheckBox.isSelected();
    }

    public Boolean confirmSeleniumCheckBox(){
        return confirmSeleniumCheckBox.isSelected();
    }

    public Boolean deSelectOnlyCheckBoxSelectOnlyCheckBox(){
        deSelectOnlyCheckBoxSelectOnlyCheckBox.click();
        return !deSelectOnlyCheckBoxSelectOnlyCheckBox.isSelected();
    }

    public Boolean selectAllBelowCheckBox(){
        selectAllBelowCheckBox.forEach(WebElement::click);
        return selectAllBelowCheckBox.stream().allMatch(WebElement :: isSelected);
    }
}
