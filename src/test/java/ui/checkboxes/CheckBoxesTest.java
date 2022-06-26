package ui.checkboxes;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.checkboxes.CheckBoxesPage;
import ui.BaseTest;

public class CheckBoxesTest extends BaseTest {

    private CheckBoxesPage checkBoxesPage;

    @BeforeMethod
    public void setUp(){
        checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.navigate();
    }

    @Test
    public void checkBoxJavaTest(){
        Assert.assertTrue(checkBoxesPage.languagesCheckBox());
    }

    @Test
    public void checkBoxSeleniumTest(){
        Assert.assertTrue(checkBoxesPage.confirmSeleniumCheckBox());
    }

    @Test
    public void checkBoxIAmTest(){
        Assert.assertTrue(checkBoxesPage.deSelectOnlyCheckBoxSelectOnlyCheckBox());
    }

    @Test
    public void checkBoxesOptionTest(){
        Assert.assertTrue(checkBoxesPage.selectAllBelowCheckBox());
    }
}
