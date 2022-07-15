package ui.wait;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wait.AppearWaitPage;
import pages.wait.DisappearWaitPage;
import pages.wait.TextChangeWaitPage;
import ui.BaseTest;

public class WaitTest extends BaseTest {

    @Test
    public void CheckDisappearTextTest(){
        DisappearWaitPage disappearWaitPage = new DisappearWaitPage(driver);
        disappearWaitPage.navigate();

        Assert.assertEquals(disappearWaitPage.checkDisappearText(), "I'm going to disapper.Keep looking at me !!");
        Assert.assertTrue(disappearWaitPage.checkWaitDisappearText());
    }

    @Test
    public void CheckAppearTextTest(){
        AppearWaitPage appearWaitPage = new AppearWaitPage(driver);
        appearWaitPage.navigate();

        Assert.assertTrue(appearWaitPage.checkAppearText());
        Assert.assertEquals(appearWaitPage.checkWaitAppearText(), "Voila! I'm here Guys");
    }

    @Test
    public void CheckChangeTextTest(){
        TextChangeWaitPage textChangeWaitPage = new TextChangeWaitPage(driver);
        textChangeWaitPage.navigate();

        Assert.assertEquals(textChangeWaitPage.checkChangeText(), "I'm going to change text!!");
        Assert.assertEquals(textChangeWaitPage.checkWaitChangeText(), "Click ME!");
    }
}