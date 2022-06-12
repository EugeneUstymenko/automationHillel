package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.regex.Pattern;

public class HomePage extends BasePage {

    private final By writeLetterButton = By.xpath("//button[text()='Написати листа']");
    //private By writeLetterButton = By.cssSelector(".primary.compose");
    private final By toInput = By.name("toFieldInput");
    private final By subjectInput = By.name("subject");
    private final By letterBody = By.id("tinymce");
    private final By sendButton = By.cssSelector(".screen__head .send.button");
    private final By bodyIFrame = By.cssSelector("#mce_0_ifr");
    private final By letterIsSend = By.cssSelector(".sendmsg__ads-ready");

    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
    }

    public void clickWriteLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(writeLetterButton));
        driver.findElement(writeLetterButton).click();
    }

    public void writeLetter(String to, String subject, String body) {
        driver.findElement(toInput).sendKeys(to);
        driver.findElement(subjectInput).sendKeys(subject);
        try {
            driver.switchTo().frame(driver.findElement(bodyIFrame));
            driver.findElement(letterBody).sendKeys(body);
        }
        finally {
            driver.switchTo().parentFrame();
        }
    }

    public void sendLetter() {
        driver.findElement(sendButton).click();
    }

    public boolean getTextLetterIsSend(String expectedTExt){
        return webDriverWait.until(ExpectedConditions.textMatches(letterIsSend, Pattern.compile("^" + expectedTExt + "\n.*")));
    }
}