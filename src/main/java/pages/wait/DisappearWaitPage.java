package pages.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.time.Duration;

public class DisappearWaitPage extends BasePage {

    @FindBy(css = "#btn")
    private WebElement disappearText;

    public DisappearWaitPage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/pages/disapper.html";
    }

    public String checkDisappearText(){
        return disappearText.getText();
    }

    public Boolean checkWaitDisappearText(){
        webDriverWait.withTimeout(Duration.ofSeconds(4)).until(ExpectedConditions.invisibilityOf(disappearText));
        return !disappearText.isDisplayed();
    }
}
