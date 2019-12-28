package pages;

import base.BasePage;
import driver2.constants.ActionType;
import driver2.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage<LandingPage> {

    By linkLogin = By.xpath("//a[@class='login']");
    By linkContactUs = By.xpath("//a[@title='Contact Us']");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return "/";
    }

    public void signIn(){
        explicitWait.
                until(ExpectedConditions.visibilityOf(wd.findElement(linkLogin)));
        WebUtils.action(ActionType.CLICK).accept(wd.findElement(linkLogin));
    }
}


