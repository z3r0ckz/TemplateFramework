package Pages;

import A1QA.Browser.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public abstract class BaseForm {

    protected WebDriver driver;

    public BaseForm(WebDriver driver) {
        this.driver = driver;
    }

    protected void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        element.click();
    }

    public static void SwitchToTab(int tabIndex) throws IOException {
        Set<String> windowHandles = Singleton.Driver("chrome").getWindowHandles();
        String tabToSwitch = new ArrayList<>(windowHandles).get(tabIndex);
        Singleton.Driver("chrome").switchTo().window(tabToSwitch);
    }

    protected void waitForElementToBeVisible(By by) throws IOException {
        int timeoutInSeconds = 3;
        Duration durationTimeout = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(Singleton.Driver("chrome"),durationTimeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }




}