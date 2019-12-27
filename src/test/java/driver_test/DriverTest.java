package driver_test;

import base.BaseTest;
import driver2.ActionType;
import driver2.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DriverTest extends BaseTest {

    @Test
    public void launchDriver() {
        wd.get("http://automationpractice.com/index.php");

        WebUtils.action(ActionType.CLICK)
                .accept(wd.findElement(By.xpath("//a[@class='login']")));

        WebUtils.waitForPageLoad().accept(wd);

        WebUtils.verification(ActionType.DISPLAYED)
                .test(wd.findElement(By.id("email_create")));

        WebUtils.interaction(ActionType.FILL)
                .accept(wd.findElement(By.id("email_create")),
                        "hemant@gmail.com");

        WebUtils.action(ActionType.CLICK).accept(wd.findElement(By.id("SubmitCreate")));

        WebUtils.EXPLICIT_WAIT.apply(wd)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.id("days"))));

        WebUtils.interaction(ActionType.SELECT).accept(wd.findElement(By.id("days")), 10);
    }
}
