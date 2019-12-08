package driver.implementation;

import driver.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FireFoxDriverManager extends DriverManager {

    private GeckoDriverService fxService;

    @Override
    protected void startService() {
        if(null == fxService){
            try{
                fxService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("src/main/resources/geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != fxService && fxService.isRunning())
            fxService.stop();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(fxService, capabilities);
    }
}
