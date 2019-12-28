package driver2;

import driver2.constants.ActionType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class WebUtils {

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

    /****************************************************************
     * Action
     ***************************************************************/
    private static final Consumer<WebElement> CLICK_ELEMENT = webElement -> {
        DISPLAYED.and(ENABLE).test(webElement);
        webElement.click();
    };

    private static final Map<ActionType, Consumer<WebElement>> ACTION_MAP = new HashMap<>();

    static{
        ACTION_MAP.put(ActionType.CLICK, CLICK_ELEMENT);
    }

    public static Consumer<WebElement> action(ActionType action) {
        return ACTION_MAP.get(action);
    }

    /****************************************************************
     *Interaction
     ***************************************************************/
    private static final BiConsumer<WebElement, Object> FILL = (element, value) -> {
        DISPLAYED.and(ENABLE).test(element);
        element.clear();
        element.sendKeys(value.toString());
    };

    private static final BiConsumer<WebElement, Object> SELECT_HANDLER = (element, value) -> {
        DISPLAYED.and(ENABLE).test(element);
        Select select = new Select(element);
        select.selectByValue(value.toString());
    };

    private static final Map<ActionType, BiConsumer<WebElement, Object>> INTERACTION_MAP = new HashMap<>();

    static{
        INTERACTION_MAP.put(ActionType.FILL, FILL);
        INTERACTION_MAP.put(ActionType.SELECT, SELECT_HANDLER);
    }

    public static BiConsumer<WebElement, Object> interaction(ActionType action) {
        return INTERACTION_MAP.get(action);
    }
}
