package ui.configtest;

import configreader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class ConfigTest {

    @Test
    public void ownerConfigTest() {
        FrameworkProperties frameworkProperties =
                ConfigFactory.create(FrameworkProperties.class);
        System.out.println(frameworkProperties.getFooBar());
        System.out.println(frameworkProperties.getTextTest());
        System.out.println(frameworkProperties.getPageTimeout());
        System.out.println(frameworkProperties.getImplicitlyTimeout());
    }
}
