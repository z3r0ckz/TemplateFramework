package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BaseForm {

    protected WebDriver driver;

    public BaseForm(WebDriver driver) {
        this.driver = driver;
    }

    protected void findElement(WebElement element, String text){
        element.findElement(By.xpath(text));
    }
    protected void isDisplayed(WebElement element){
        element.isDisplayed();
    }
    protected void getAttribute(WebElement element, String text){
        element.getAttribute(String.valueOf(By.xpath(text)));
    }
    protected void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        element.click();
    }


}