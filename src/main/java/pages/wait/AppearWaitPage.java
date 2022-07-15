package pages.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.time.Duration;

public class AppearWaitPage extends BasePage {

    @FindBy(css = "#btn")
    private WebElement appearText;

    public AppearWaitPage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/pages/appear.html";
    }

    public Boolean checkAppearText(){
        return !appearText.isDisplayed();
    }

    public String checkWaitAppearText(){
        webDriverWait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(appearText));
        if(appearText.isDisplayed()){
            return appearText.getText();
        }
        return null;
    }
}
