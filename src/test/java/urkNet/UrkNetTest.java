package urkNet;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MailinatorInboxPage;
import testdata.User;
import java.util.concurrent.TimeUnit;

public class UrkNetTest {

    private static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //Пока мы не разбирали как настроить работу селениума (вейты) - такое решение
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

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

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
