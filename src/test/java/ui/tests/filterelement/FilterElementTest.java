package ui.tests.filterelement;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.filterelement.FilterElementPage;
import ui.tests.BaseTest;
import java.util.ArrayList;
import java.util.List;

public class FilterElementTest extends BaseTest {

    @Test
    public void FindFilterElementTest(){
        FilterElementPage filterElementPage = new FilterElementPage(driver);
        filterElementPage.navigate();
        List<String> filterElement= new ArrayList<>();
            filterElement.add("Alert");
            filterElement.add("Auto Complete");

        Assert.assertEquals(filterElementPage.filterTitles(), filterElement);
    }
}
