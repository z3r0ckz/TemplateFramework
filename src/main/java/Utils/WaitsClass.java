package Utils;

import A1QA.Browser.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class WaitsClass {

    int timeoutInSeconds = 3;
    Duration durationTimeout = Duration.ofSeconds(timeoutInSeconds);
    WebDriverWait wait = new WebDriverWait(Singleton.Driver("chrome"),durationTimeout);

    public WaitsClass() throws IOException {
    }

    protected void waitForElementToBeVisible(By by) throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementToBeClicked(By by) throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void waitForElementToDisappear(By locator) throws IOException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
}
