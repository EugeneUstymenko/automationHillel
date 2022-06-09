import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class TestCheckboxesHomework {
    private final By languagesCheckBoxInputLocator = By.xpath("//label[text()='Select the languages that you know?']" +
            "/following-sibling::input");
    private final By confirmSeleniumCheckBoxInputLocator = By.xpath("//label[text()='Confirm Selenium is checked']" +
            "/following-sibling::input");
    private final By deSelectOnlyCheckBoxSelectOnlyCheckBoxInputLocator = By.xpath("//label[text()='DeSelect only checked']" +
            "/following-sibling::input[2]");
    private final By selectAllBelowCheckBoxInputLocator = By.xpath("//label[text()='Select all below checkboxes ']" +
            "/following-sibling::input");
    private static WebDriver driver;
    private WebElement languagesCheckBox;
    private WebElement confirmSeleniumCheckBox;
    private WebElement deSelectOnlyCheckBoxSelectOnlyCheckBox;
    private List<WebElement> selectAllBelowCheckBox;

    @BeforeClass
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        String baseUrl = "http://www.leafground.com/pages/checkbox.html";
        driver = new ChromeDriver();
        driver.get(baseUrl);

        languagesCheckBox = driver.findElement(languagesCheckBoxInputLocator);
        languagesCheckBox.click();

        confirmSeleniumCheckBox = driver.findElement(confirmSeleniumCheckBoxInputLocator);

        deSelectOnlyCheckBoxSelectOnlyCheckBox = driver.findElement(deSelectOnlyCheckBoxSelectOnlyCheckBoxInputLocator);
        deSelectOnlyCheckBoxSelectOnlyCheckBox.click();

        selectAllBelowCheckBox = driver.findElements(selectAllBelowCheckBoxInputLocator);
        for (WebElement checkBox : selectAllBelowCheckBox) {
            checkBox.click();
        }
    }
    @Test
    public void checkBoxJavaTests(){
        Assert.assertTrue(languagesCheckBox.isSelected());
    }
    @Test
    public void checkBoxSeleniumTests(){
        Assert.assertTrue(confirmSeleniumCheckBox.isSelected());
    }
    @Test
    public void checkBoxIAmTests(){
        Assert.assertFalse(deSelectOnlyCheckBoxSelectOnlyCheckBox.isSelected());
    }
    @Test
    public void checkBoxesOption(){
        for (WebElement checkBox:selectAllBelowCheckBox) {
            Assert.assertTrue(checkBox.isSelected());
        }
    }
    @org.junit.AfterClass
    public static void tearDown(){
        driver.close();
    }
}
