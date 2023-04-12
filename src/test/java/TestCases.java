import A1QA.Browser.ConfigManager;
import A1QA.Browser.Singleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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


    }

    @AfterClass
    public void terminateBrowser() throws IOException {
        System.out.println("End of the Test");
        Singleton.Driver("chrome").quit();
    }
}
