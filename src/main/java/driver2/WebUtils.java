package driver2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class WebUtils {

    /****************************************************************
     * Waits
     ***************************************************************/
    private static final Consumer<WebDriver> PAGE_LOAD = driver -> {
        new WebDriverWait(driver, Duration.ofSeconds(120))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    };

    public static Consumer<WebDriver> waitPageLoad(){
        return PAGE_LOAD;
    }


    /****************************************************************
     * Action
     ***************************************************************/
    private static final Consumer<WebElement> CLICK_ELEMENT = webElement -> {

    };


    private static final Map<ActionType, Consumer<WebElement>> ACTION_MAP = new HashMap<>();

    static{
        ACTION_MAP.put(ActionType.CLICK, CLICK_ELEMENT);
    }

    public static Consumer<WebElement> action(ActionType action) {
        return ACTION_MAP.get(action);
    }

    /****************************************************************
     * Interaction
     ***************************************************************/
    private static final BiConsumer<WebElement, Object> FILL = (element, value) ->
            element.sendKeys(value.toString());
    private static final Map<ActionType, BiConsumer<WebElement, Object>> INTERACTION_MAP = new HashMap<>();

    static{
        INTERACTION_MAP.put(ActionType.FILL, FILL);
    }

    public static BiConsumer<WebElement, Object> interaction(ActionType action) {
        return INTERACTION_MAP.get(action);
    }

    /**************************************************************
     * Verification
     ***************************************************************/
    private static final Predicate<WebElement> DISPLAYED = WebElement::isDisplayed;
    private static final Predicate<WebElement> ENABLE = WebElement::isEnabled;
    private static final Predicate<WebElement> SELECTED = WebElement::isSelected;

    private static final Map<ActionType, Predicate<WebElement>> VERIFICATION_MAP = new HashMap<>();

    static{
        VERIFICATION_MAP.put(ActionType.DISPLAYED, DISPLAYED);
        VERIFICATION_MAP.put(ActionType.ENABLE, ENABLE);
        VERIFICATION_MAP.put(ActionType.SELECTED, SELECTED);
    }

    public static Predicate<WebElement> verification(ActionType action){
        return VERIFICATION_MAP.get(action);
    }


}
