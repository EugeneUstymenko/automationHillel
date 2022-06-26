package pages.filterelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import java.util.List;
import java.util.stream.Collectors;

public class FilterElementPage extends BasePage {

    @FindBy(css = ".wp-categories-title")
    private List<WebElement> titles;

    public FilterElementPage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/home.html";
    }

    public List<String> filterTitles(){
        return titles.stream()
                .map(WebElement::getText)
                .filter(text -> text.charAt(0) == 'A')
                .collect(Collectors.toList());
    }
}
