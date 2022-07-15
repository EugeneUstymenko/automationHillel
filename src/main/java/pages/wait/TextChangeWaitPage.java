package pages.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.time.Duration;

public class TextChangeWaitPage extends BasePage {

    @FindBy(css = "#btn")
    private WebElement changeText;

    public TextChangeWaitPage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/pages/TextChange.html";
    }

    public String checkChangeText(){
        return changeText.getText();
        //I'm going to change text!!
    }

    public String checkWaitChangeText(){
        webDriverWait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions
                .textToBePresentInElement(changeText, "Click ME!"));
        return changeText.getText();
    }
}
