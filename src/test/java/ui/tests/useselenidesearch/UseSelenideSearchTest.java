package ui.tests.useselenidesearch;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class UseSelenideSearchTest {

    private GoogleHomePage googleHomePage;

    @BeforeClass
    public void setUpClass(){
        Configuration.savePageSource = false;
        Configuration.timeout = 4000;//по умолчанию
        Configuration.browserSize = "1920x1080";
    }

    @BeforeMethod
    public void setUpMethod(){
        open("https://google.com");
        googleHomePage = new GoogleHomePage();
        googleHomePage
                .waitUntilSearchFieldDisplayed()
                .setSearchText("Selenide")
                .pressEnter();
    }

    @Test
    public void googleSearch(){
        $$x("//h3[contains(text(), 'Selenide')]")
                .filter(visible)
                .shouldHave(sizeGreaterThanOrEqual(7));
    }

    @Test
    public void siteSelenideSupport(){
        googleHomePage.openSelenideSite();

        $(".wrapper-color-content")
                .shouldHave(text("Селенид поддерживает Украину \uD83C\uDDFA\uD83C\uDDE6"));
    }

    @Test
    public void checkOpenBlog(){
        googleHomePage.openSelenideSite();

        $x("//a[contains(text(), 'Блог')]")
                .click();

        $x("//h3[contains(text(), 'Блог Selenide')]")
                .shouldHave(text("Блог Selenide"));
    }
}
