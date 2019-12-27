package base;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class BasePage<T extends BasePage> {
    protected WebDriver wd;
    protected FluentWait<WebDriver> wait = null;
    public abstract String getURL();


    public BasePage(WebDriver driver) {
        this(driver, false);
    }

    public BasePage(WebDriver driver, boolean waitForLoad) {
        wd = driver;
        wait = new FluentWait<>(wd)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(wd, this);

    }

    public void acceptAlertIfPresent(WebDriver wd) {
        try {

            wd.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {
            // TODO: handle exception
        }
    }

    public T navigateTo() {
        wd.get(url);
        acceptAlertIfPresent(wd);
        return (T) this;
    }

}
