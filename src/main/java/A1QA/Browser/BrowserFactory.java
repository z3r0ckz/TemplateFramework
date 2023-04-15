package A1QA.Browser;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browserName) throws IOException {
        switch (browserName.toLowerCase()) {
            case "chrome" -> {
                if (driver == null) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(BrowserUtils.readChromeBrowserConfig());
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(options);
                }
            }
            case "firefox" -> {
                if (driver == null) {
                    FirefoxOptions optionsFx = new FirefoxOptions();
                    optionsFx.addArguments(BrowserUtils.readFirefoxConfig());
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(optionsFx);
                }
            }
            default -> throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        return driver;
    }
}
