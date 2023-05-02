package Utils;

import A1QA.Browser.Browser;
import Base.Wrappers.Button;
import org.openqa.selenium.Alert;

public class AlertsUtils {

    public static void simpleAlert(Button button){
        button.click();
        Alert simpleAlert = Browser.Driver().switchTo().alert();
        MyLogger.info("Click on OK in simple alert");
        simpleAlert.accept();
    }
    public static void promptAlertTypeText(Button button, String text){
        button.click();
        Alert promtAlert = Browser.Driver().switchTo().alert();
        promtAlert.sendKeys(text);
        MyLogger.info("Send keys to Prompt alert: "+ text);
        promtAlert.accept();
    }
}
