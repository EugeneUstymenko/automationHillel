package ui.tests.ukrnet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mailinator.MailinatorInboxPage;
import pages.ukrnet.HomePage;
import pages.ukrnet.LoginPage;
import testdata.User;
import ui.tests.BaseTest;

public class UrkNetTest extends BaseTest {

    @Test
    public void sendEmailToMailinatorTest() {

        User user = new User("lperevoznyk@ukr.net", "Qwerty!2345");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);

        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
        homePage.clickWriteLetter();
        homePage.writeLetter("lperevonyktest@mailinator.com", "qwerty", "test body");
        homePage.sendLetter();

        Assert.assertTrue(homePage.getTextLetterIsSend("Ваш лист надіслано"));

        MailinatorInboxPage mailinatorHomePage = new MailinatorInboxPage(driver);
        mailinatorHomePage.navigate();
        mailinatorHomePage.goToInbox("lperevonyktest");
        mailinatorHomePage.clickLastLetter();

        Assert.assertEquals(mailinatorHomePage.checkSubjectLetter(), "qwerty");
        Assert.assertEquals(mailinatorHomePage.checkLetterFrom(), "lperevoznyk@ukr.net");
        Assert.assertEquals(mailinatorHomePage.checkTextLetter(), "test body");
    }
}
