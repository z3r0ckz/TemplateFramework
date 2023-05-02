package Utils;

import A1QA.Browser.Browser;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    protected static final JavascriptExecutor js = (JavascriptExecutor) Browser.Driver();
    public BrowserUtils() {
    }
    public static int getActualIndexTab() {
        int currentWindowIndex = -1;
        String currentWindowHandle = Browser.Driver().getWindowHandle();

        Set<String> windowHandles = Browser.Driver().getWindowHandles();
        int i = 0;
        for (String windowHandle : windowHandles) {
            if (windowHandle.equals(currentWindowHandle)) {
                currentWindowIndex = i;
                break;
            }
            i++;
        }
        return currentWindowIndex;
    }
    public static String getWindowHandle() {
        return Browser.Driver().getWindowHandle();
    }
    public static Set<String> getWindowHandles() {
        return Browser.Driver().getWindowHandles();
    }
    public static void changeActiveTab()  {
        Set<String> windowHandles = getWindowHandles();
        String currentHandle = getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentHandle)) {
                Browser.Driver().switchTo().window(windowHandle);
            }
        }
    }
    public static void SwitchToTabNumber(int tabNumber) {
        List<String> handlesList = new ArrayList<>(getWindowHandles());
        Browser.Driver().switchTo().window(handlesList.get(tabNumber));
    }
    public static void switchToFrame(WebElement frame)  {
        Browser.Driver().switchTo().frame(frame);
    }
    /*public static void scrollDown() {
        js.executeScript("window.scrollBy(0, 500)");
    }
*/
    public static void scrollFindLocator(By locator) {
        WebElement element = Browser.Driver().findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void scrollUP(){
            js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

    }
    public static void switchToParentFrame()  {
        Browser.Driver().switchTo().parentFrame();
    }

    public static void scrollDown() {
        js.executeScript("window.scrollBy(0, 500)");
    }
}