package utility;

import org.aeonbits.owner.ConfigFactory;

public class PropertyUtils {

    private static Environment testEnvironment;

    static {
        try {
            testEnvironment = ConfigFactory.create(Environment.class);
        } catch (Exception ignored) {
        }
    }

    public static Environment getProperty(){
        return testEnvironment;
    }
}
