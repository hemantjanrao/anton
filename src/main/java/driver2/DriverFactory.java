package driver2;

import driver2.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class DriverFactory {

    private DriverFactory(){}

    private static Supplier<WebDriver> chromeSupplier = () -> {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");

        return new ChromeDriver(options);
    };

    private static Supplier<WebDriver> fireFoxSupplier = () -> {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");

        return new FirefoxDriver(options);
    };

    private static final Map<DriverType, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put(DriverType.CHROME, chromeSupplier);
        MAP.put(DriverType.FIREFOX, fireFoxSupplier);
    }

    public static WebDriver getDriver(DriverType browser){
        return MAP.get(browser).get();
    }
}
