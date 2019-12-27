package base;


import driver2.DriverFactory;
import driver2.DriverType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest{
    protected WebDriver wd = null;

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() {
        try {
            wd = DriverFactory.getDriver(DriverType.CHROME);
            wd.manage().timeouts().pageLoadTimeout(60, SECONDS);
            wd.manage().timeouts().implicitlyWait(10, SECONDS);
            System.setProperty("webdriver.timeouts.implicitlywait", "30");
            wd.manage().window().maximize();
        } catch (Exception e) {
            Assert.fail("Error creating driver", e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void destroyDriver() {
        try {
            wd.quit();
        } catch (UnhandledAlertException e) {
            wd.switchTo().alert().accept();
        }
    }

    @BeforeClass(alwaysRun = true)
    public void baseTestBeforeClass() {
        System.out.println("Starting the Before class of 'Base Test'");
    }

    @AfterClass(alwaysRun = true)
    public void baseTestAfterClass() {

        System.out.println("Starting the After class of 'Base Test'");
    }


    @BeforeMethod(alwaysRun = true)
    public void logStartMethod(Method testMethod) {
        System.out.println("Starting tests method '" + testMethod.getName() + "'");
    }


    @AfterMethod(alwaysRun = true)
    public void logEndMethod(Method testMethod) {
        System.out.println("Ending tests method '" + testMethod.getName() + "'");
    }


    /*public void takeScreenShot(String testName) {
        if (Objects.isNull(wd)) {
            log.warn("WebDriver is null, unable to save screenshot");

        }
        try {
            TakesScreenshot shot = (TakesScreenshot) this.wd;
            File file = (File) shot.getScreenshotAs(OutputType.FILE);
            String fileName = String.format("snapshot_%s.png", testName);
            Path path = Paths.get("target/screenshot", testName, fileName);
            Files.createDirectories(path.getParent());
            Files.copy(file.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Screenshot saving failed", e);
        }
    }*/

}
