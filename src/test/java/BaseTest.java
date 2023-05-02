import A1QA.Browser.ConfigManager;
import A1QA.Browser.Browser;
import Utils.MyLogger;
import Utils.RandomUtils;
import Utils.TestReader;
import Utils.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public abstract class BaseTest {
    protected final ConfigManager config = new ConfigManager();
    protected final String url = config.getProperty("url");
    protected final WebDriver driver = Browser.Driver();

    protected final By PageLocator_Main = By.xpath("//header[@href=www.demoqa.com]");
    protected final By PageLocator_Alerts = By.xpath("//div[@class='main-header' and contains(text(),'Alerts, Frame & Windows')]");
    protected final By PageLocator_Elements = By.xpath("//div[@class='main-header' and contains(text(),'Elements')]");
    protected final By PageLocator_BrowserWindows = By.xpath("//div[@class='main-header' and contains(text(),'Browser Windows')]");
    protected final By PageLocator_Links =By.xpath("//div[@class='main-header' and contains(text(),'Links')]");
    protected final WaitsUtil waits;
    protected final String nameRandom = RandomUtils.generateRandomUsername();
    protected final TestReader testdata = new TestReader("src/main/resources/testDataRegistrationForm.json");
    public BaseTest(WaitsUtil waits) throws IOException {
        this.waits = waits;
    }
    @BeforeClass
    public void setWebpage() {
        //1 - Navigate to MainPage
        driver.get(url);
        MyLogger.info("Go to the main page: "+ url);
    }
    @AfterClass
    public void tearDown() {
        MyLogger.info("End of the test (Teardown)  - Browser Quit");
        driver.quit();
    }
}
