package cucumber.glue.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before(order = 0)
    public void firstBefore() {
        System.out.println("First before");
    }

    @Before(order = 1, value = "@SecondBefore")
    public void secondBefore() {
        System.out.println("Second before");
    }
}
