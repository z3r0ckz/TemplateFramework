package Utils;

import A1QA.Browser.ConfigManager;
import A1QA.Browser.Singleton;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;


public class BrowserUtils {
    static ConfigManager config = new ConfigManager();
    static String browser = config.getProperty("browser");

    public static String @NotNull [] readChromeBrowserConfig() throws IOException {
        String browserConfig = new String(Files.readAllBytes(Paths.get("src/main/resources/chromeConfig.json")));
        JSONArray jsonArray = new JSONArray(browserConfig);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String browserMode = jsonObject.getString("browserMode");
        String language = jsonObject.getString("language");
        String remoteAllow = jsonObject.getString("remoteAllow");

        return new String[]{browserMode, language, remoteAllow};
    }

    public static String @NotNull [] readFirefoxConfig() throws IOException {
        String browserConfig = new String(Files.readAllBytes(Paths.get("src/main/resources/firefoxConfig.json")));
        JSONArray jsonArray = new JSONArray(browserConfig);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String browserMode = jsonObject.getString("browserMode");
        String language = jsonObject.getString("language");

        return new String[]{browserMode, language};
    }

    public static int getActualIndexTab() throws IOException {
        int currentWindowIndex = -1;
        String currentWindowHandle = Singleton.Driver(browser).getWindowHandle();

        Set<String> windowHandles = Singleton.Driver(browser).getWindowHandles();
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

    public static String getHeader() throws IOException {
        String getHeaderText;
        getHeaderText = Singleton.Driver(browser).getTitle();


        return getHeaderText;
    }

    public void scrollDownFindElement(@NotNull JavascriptExecutor js, WebElement element) throws IOException, InterruptedException {
        js.executeScript("arguments[0].scrollIntoView()", Singleton.Driver(browser).findElement((By) element));
    }

    public void clickAndOpenNewTab(WebElement element) throws  IOException {
        Actions action = new Actions(Singleton.Driver(browser));
        action.keyDown(Keys.CONTROL).moveToElement(element).click().perform();
        ArrayList<String> tabs = new ArrayList<>(Singleton.Driver(browser).getWindowHandles());
        Singleton.Driver(browser).switchTo().window(tabs.get(1));
    }
}