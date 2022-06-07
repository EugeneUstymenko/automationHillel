import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.List;

public class TestCheckboxesHomework {
    private String baseUrl = "http://www.leafground.com/pages/checkbox.html";
    private By languagesCheckBoxInputLocator = By.xpath("//*[@id='contentblock']/section/div[1]/input[1]");
    private By confirmSeleniumCheckBoxInputLocator = By.xpath("//*[@id='contentblock']/section/div[2]/" +
            "text()='Selenium'");
    private By deSelectOnlyCheckBoxSelectOnlyCheckBoxInputLocator = By.xpath("//*[@id=эcontentblockэ]/" +
            "section/div[3]/text()='I am Selected'");
    private By selectAllBelowCheckBoxInputLocator = By.xpath("//*[@id='contentblock']/section/div[3]/input" +
            "text()[2]");
    private WebDriver driver;
    private WebElement languagesCheckBox;
    private WebElement confirmSeleniumCheckBox;
    private WebElement deSelectOnlyCheckBoxSelectOnlyCheckBox;
    //private WebElement selectAllBelowCheckBox;
    private List<WebElement> selectAllBelowCheckBox;

    @BeforeClass
    public void setUo(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

        languagesCheckBox = driver.findElement(languagesCheckBoxInputLocator);
        languagesCheckBox.click();

        confirmSeleniumCheckBox = driver.findElement(confirmSeleniumCheckBoxInputLocator);
        deSelectOnlyCheckBoxSelectOnlyCheckBox = driver.findElement(deSelectOnlyCheckBoxSelectOnlyCheckBoxInputLocator);
        //selectAllBelowCheckBox = driver.findElement(selectAllBelowCheckBoxInputLocator);
        selectAllBelowCheckBox = driver.findElements(selectAllBelowCheckBoxInputLocator);
    }

    @Test
    public void checkBoxJavaTests(){

        Assert.assertTrue(languagesCheckBox.isSelected());
    }
}
