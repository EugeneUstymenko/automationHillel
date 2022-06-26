package pages.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import testdata.User;

public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private WebElement loginField;
    @FindBy(css = "[name='password']")
    private WebElement passwordField;
    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/";
    }

    public void login(User user) {
        loginField.sendKeys(user.login());
        passwordField.sendKeys(user.password());
        submitButton.click();
    }
}
