package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void waitUntilLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.urlContains(pageUrl));
    }

    public void navigate() {
        driver.get(pageUrl);
    }

    //For example JavascriptExecutor
    /*public void waitUntilJsIsReady() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        webDriverWait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }*/
}
