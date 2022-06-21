package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorInboxPage extends BasePage{

    @FindBy(xpath = "//td[contains(text(), 'qwerty')]")
    private WebElement lastLetter;
    @FindBy(id = "inbox_field")
    private WebElement inboxField;
    @FindBy(className = "primary-btn")
    private WebElement goButton;
    @FindBy(xpath = "//div[contains(text(), 'qwerty')]")
    private WebElement subjectLetter;
    @FindBy(xpath = "//div[contains(text(), 'lperevoznyk@ukr.net')]")
    private WebElement letterFrom;
    @FindBy(css = "#html_msg_body")
    private WebElement bodyMailinatorIFrame;
    @FindBy(css = ".xfmc1")
    private WebElement textLetter;

    public MailinatorInboxPage(WebDriver driver){
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
    }

    public void clickLastLetter(){
        webDriverWait.until(ExpectedConditions.visibilityOf(lastLetter));
        lastLetter.click();
    }

    public void goToInbox(String inbox){
        inboxField.sendKeys(inbox);
        goButton.click();
    }

    public String checkSubjectLetter(){
        return subjectLetter.getText();
    }

    public String checkLetterFrom(){
        return letterFrom.getText();
    }

    public String checkTextLetter(){
        String textLetter;
        try{
            driver.switchTo().frame(bodyMailinatorIFrame);
            textLetter = this.textLetter.getText();
        }
        finally {
            driver.switchTo().parentFrame();
        }
        return textLetter;
    }
}
