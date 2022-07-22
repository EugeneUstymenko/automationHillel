package ui.tests.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.theinternet.TheInternetLoginPage;
import testdata.User;
import ui.tests.BaseTest;
import ui.dataproviders.DataProviders;

public class TheInternetLoginTest extends BaseTest {

    @Test(testName = "First test", description = "Error message should appears if user enters invalid credentials",
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