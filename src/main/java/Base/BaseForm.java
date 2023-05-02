package Base;

import Utils.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
public abstract class BaseForm {
    protected  WaitsUtil waits;
    protected  By uniqueFormLocator;
    protected String formName;
    public BaseForm(By uniqueFormLocator, String formName){
        this.uniqueFormLocator = uniqueFormLocator;
        this.formName = formName;
        waits = new WaitsUtil();
    }
    public boolean isPageOpen(By uniqueFormLocator) {
        try {
            waits.waitElementDisplayed(uniqueFormLocator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}