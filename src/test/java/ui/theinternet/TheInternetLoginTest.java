package ui.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.theinternet.TheInternetLoginPage;
import testdata.User;
import ui.BaseTest;
import ui.dataproviders.DataProviders;

public class TheInternetLoginTest extends BaseTest {

    @Test(description = "Error message should appears if user enters invalid credentials",
            dataProvider = "user-credentials",
            dataProviderClass = DataProviders.class)
    public void errorMessageShouldAppears(String login, String password, String errorMessage) {
        User user = new User(login, password);
        TheInternetLoginPage theInternetLoginPage = new TheInternetLoginPage(driver);
        theInternetLoginPage.navigate();
        theInternetLoginPage.login(user);
        Assert.assertEquals(theInternetLoginPage.getErrorMessage(), errorMessage);
    }
}