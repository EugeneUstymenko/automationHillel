package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[text()='Написати листа']")
    private WebElement writeLetterButton;
    @FindBy(name = "toFieldInput")
    private WebElement toInput;
    @FindBy(name = "subject")
    private WebElement subjectInput;
    @FindBy(id = "tinymce")
    private WebElement letterBody;
    @FindBy(css = ".screen__head .send.button")
    private WebElement sendButton;
    @FindBy(css = "#mce_0_ifr")
    private WebElement bodyIFrame;
    @FindBy(css = ".sendmsg__ads-ready")
    private WebElement letterIsSend;

    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
    }

    public void clickWriteLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(writeLetterButton));
        writeLetterButton.click();
    }

    public void writeLetter(String to, String subject, String body) {
        toInput.sendKeys(to);
        subjectInput.sendKeys(subject);
        try {
            driver.switchTo().frame(bodyIFrame);
            letterBody.sendKeys(body);
        }
        finally {
            driver.switchTo().parentFrame();
        }
    }

    public void sendLetter() {
        sendButton.click();
    }

    public boolean getTextLetterIsSend(String expectedTExt){
        return webDriverWait.until(ExpectedConditions.textToBePresentInElement(letterIsSend, expectedTExt));
    }
}