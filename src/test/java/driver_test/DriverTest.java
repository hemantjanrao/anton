package driver_test;

import base.BaseTest;
import driver2.constants.ActionType;
import driver2.WebUtils;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;

public class DriverTest extends BaseTest {

    LandingPage lp = null;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        lp = new LandingPage(wd).navigateTo();
    }

    /*@Test
    public void launchDriver() {
        wd.get("http://automationpractice.com/index.php");

        WebUtils.action(ActionType.CLICK)
                .accept(wd.findElement(By.xpath("//a[@class='login']")));


        WebUtils.verification(ActionType.DISPLAYED)
                .test(wd.findElement(By.id("email_create")));

        WebUtils.interaction(ActionType.FILL)
                .accept(wd.findElement(By.id("email_create")),
                        "hemant@gmail.com");

        WebUtils.action(ActionType.CLICK).accept(wd.findElement(By.id("SubmitCreate")));

        WebUtils.interaction(ActionType.SELECT).accept(wd.findElement(By.id("days")), 10);
    }*/

    @Test
    public void testFirst(){

        lp.signIn();
    }
}
