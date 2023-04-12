import A1QA.Browser.ConfigManager;
import A1QA.Browser.Singleton;
import Utils.MyLogger;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestCases {
    @BeforeClass
    public void setWebpage() throws IOException {
        ConfigManager config = new ConfigManager();
        String url = config.getProperty("url");
        String browser = config.getProperty("browser");
        Singleton.Driver(browser).get(url);
        //Wait the webpage to charge
        int timeout = Integer.parseInt(config.getProperty("timeout"));
        Singleton.Driver(browser).manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void test1() throws IOException, InterruptedException {
        System.out.println("Test 1");
        MyLogger.info("Test 1 First Log");

    }

    @AfterClass
    public void terminateBrowser() throws IOException {
        System.out.println("End of the Test");
        Singleton.Driver("chrome").quit();
    }
}
