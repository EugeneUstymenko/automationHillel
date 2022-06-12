package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorInboxPage extends BasePage{

    private final By lastLetter = By.xpath("//td[contains(text(), 'qwerty')]");
    private final By inboxField = By.id("inbox_field");
    private final By goButton = By.className("primary-btn");
    private final By subjectLetter = By.xpath("//div[contains(text(), 'qwerty')]");
    private final By letterFrom = By.xpath("//div[contains(text(), 'lperevoznyk@ukr.net')]");
    private final By bodyMailinatorIFrame = By.cssSelector("#html_msg_body");
    private final By textLetter = By.cssSelector(".xfmc1");

    public MailinatorInboxPage(WebDriver driver){
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
    }

    public void clickLastLetter(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastLetter));
        driver.findElement(lastLetter).click();
    }

    public void goToInbox(String inbox){
        driver.findElement(inboxField).sendKeys(inbox);
        driver.findElement(goButton).click();
    }

    public String checkSubjectLetter(){
        return driver.findElement(subjectLetter).getText();
    }

    public String checkLetterFrom(){
        return driver.findElement(letterFrom).getText();
    }

    public String checkTextLetter(){
        String textLetter;
        try{
            driver.switchTo().frame(driver.findElement(bodyMailinatorIFrame));
            textLetter = driver.findElement(this.textLetter).getText();
        }
        finally {
            driver.switchTo().parentFrame();
        }
        return textLetter;
    }

    //For example ElementException time
   /* public void waitUntilLettersIsDisplayed() {
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            try {
                if (driver.findElement(lastLetter).isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        throw new TimeoutException();
    }*/
}
