package utility;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:${env}.properties" // mention the property file name
})
public interface Environment extends Config {

    @Key("retryCount")
    int retryCount();

    @Key("appURL")
    String appURL();

    @Key("environment")
    String environment();
}
