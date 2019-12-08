package driver;

import driver.implementation.ChromeDriverManager;
import driver.implementation.FireFoxDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            default:
                driverManager = null;
                break;
        }
        return driverManager;
    }
}
