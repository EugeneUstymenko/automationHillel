package pages.google;

import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleHomePage extends BasePage {

    private static final By SEARCH_FIELD = By.cssSelector("[name = 'q']");
    private static final By SELENIDE_PAGES = By.xpath("//h3[contains(text(), 'Selenide')]");

    public GoogleHomePage waitUntilSearchFieldDisplayed(){
        $(SEARCH_FIELD).shouldBe(visible);
        return this;
    }

    public GoogleHomePage setSearchText(String text){
        $(SEARCH_FIELD).setValue(text);
        return this;
    }

    public void pressEnter(){
        $(SEARCH_FIELD).pressEnter();
    }

    public void openSelenideSite(){
        $$(SELENIDE_PAGES).get(0).click();
    }
}
