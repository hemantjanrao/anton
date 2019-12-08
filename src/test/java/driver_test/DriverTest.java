package driver_test;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverTest {

    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchDriver() {
        driver.get("https://www.google.com/");
        Assert.assertEquals("Google", driver.getTitle());
    }
}
