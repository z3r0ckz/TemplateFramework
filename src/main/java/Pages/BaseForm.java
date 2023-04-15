package Pages;

import A1QA.Browser.Singleton;
import Utils.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

public abstract class BaseForm {

    public BaseForm(WebDriver driver) {
        this.driver = driver;
    }

    By uniqueLocator;
    String formName;
    WebDriver driver;
    WaitsUtil wait;

    public BaseForm(By locator, String name, String browser) throws IOException {
        uniqueLocator = locator;
        formName = name;
        driver = Singleton.Driver(browser);

    }

    public boolean isPageOpen() throws IOException {
        return wait.waitForElementToBeVisible(uniqueLocator);
    }

    public Label getFormLabel(int formNumber) {
        return new Label(formName, formNumber);
    }

}