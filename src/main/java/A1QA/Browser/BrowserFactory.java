package A1QA.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    private static WebDriver driver;
    private static final ConfigManager config = new ConfigManager();
    private static final String browserOpt = config.getProperty("browserOpt");
    public static <browserOpt> WebDriver getDriver() {
        WebDriver result = null;
        switch (browserOpt) {
            case "chrome" -> {
                if (driver == null) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(ChromeCaps.readChromeBrowserConfig());
                    WebDriverManager.chromedriver().setup();
                    result = new ChromeDriver(options);
                }
            }
            case "firefox" -> {
                if (driver == null) {
                    FirefoxOptions optionsFx = new FirefoxOptions();
                    optionsFx.addArguments(FirefoxCaps.readFirefoxBrowserConfig());
                    WebDriverManager.firefoxdriver().setup();
                    result = new FirefoxDriver(optionsFx);
                }
            }
            default -> throw new IllegalArgumentException("Invalid browser name: " + browserOpt);
        }
        if (result == null) {
            result = driver;
        }
        return result;
    }

}
