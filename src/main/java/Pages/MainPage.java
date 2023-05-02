package Pages;

import Base.BaseForm;
import Base.Wrappers.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    //-----------------------Constructor---------------------------------
    public MainPage( By uniqueFormLocator, String formName) {
        super(uniqueFormLocator, formName);
    }
    //-------------------------Locator Objects Main Page -----------------------------------
    private final Button cardAlerts =
            new Button(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]/ancestor::div[3]"),"cardAlerts");
    private final Button cardElements =
            new Button(By.xpath("//h5[contains(text(),'Elements')]/ancestor::div[1]"),"cardAlerts");
    //---------------------------------Start of the Alert methods-------------------------------
    public void clickAlerts(){
        cardAlerts.click();
    }
    public void clickElements() {
        cardElements.click();
    }
    }


