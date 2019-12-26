package driver_test;

import driver.DriverManager;
import driver2.ActionType;
import driver2.DriverFactory;
import driver2.DriverType;
import driver2.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }

    @Test
    public void launchDriver() {
        driver.get("http://automationpractice.com/index.php");

        WebUtils.action(ActionType.CLICK).accept(driver.findElement(By.xpath("//a[@class='login']")));

        WebUtils.waitPageLoad().accept(driver);

        WebUtils.verification(ActionType.DISPLAYED).test(driver.findElement(By.id("email_create")));
    }
}
