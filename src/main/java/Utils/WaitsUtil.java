package Utils;

import A1QA.Browser.ConfigManager;
import A1QA.Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitsUtil {
    private final WebDriverWait waitTime;
    public WaitsUtil(){
        ConfigManager config = new ConfigManager();
        int timeout = (int) Long.parseLong(config.getProperty("timeoutSeconds"));
        waitTime = new WebDriverWait(Browser.Driver() ,Duration.ofSeconds(timeout));
    }
    public boolean waitElementDisplayed(By locator) {
        try {
            return waitTime.until
                    (ExpectedConditions.visibilityOf(Browser.Driver().findElement(locator))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitElementToBeClicked(By locator){
        try {
            waitTime.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
