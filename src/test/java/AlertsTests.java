
import Pages.AlertsPage;
import Pages.MainPage;
import Utils.BrowserUtils;
import Utils.MyLogger;
import Utils.WaitsUtil;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;


public class AlertsTests extends BaseTest {
    protected MainPage objMainPage = new MainPage(PageLocator_Main,"MainPage");
    protected AlertsPage objAlertsPage = new AlertsPage(PageLocator_Alerts ,"AlertsPage");
    public AlertsTests() throws IOException {
        super(new WaitsUtil());
    }
    @Test(priority = 1)
    public void alertsTestCases() {
        MyLogger.info("Start of the Alerts test");
        MyLogger.info(" Click on Alerts, Frame & Windows Page");
        BrowserUtils.scrollDown();
        objMainPage.clickAlerts();
        MyLogger.info("Check if alerts Page is open");
        Assert.assertTrue(objAlertsPage.isPageOpen(PageLocator_Alerts),"The Alerts Page isn't open");
        MyLogger.info("wait to click on Alerts Button");
        BrowserUtils.scrollFindLocator(PageLocator_Alerts);
        MyLogger.info("//2.1 - Click on Alert Button");
        BrowserUtils.scrollDown();
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickAlertButton()),"The Click miss in Alert Button");
        MyLogger.info("Alerts Button was clicked");
        MyLogger.info("Click on Click me button Alerts ");
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickMeAlertButton()),"The click miss in Click me alert button");
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickOkSimpleAlert()),"The click miss in the simple alert");
        MyLogger.info("Simple Alert confirm");
        MyLogger.info("Click on button, confirm box ");
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickMeConfirmBoxButton()),"the click miss in the alert confirm box");
        MyLogger.info("Click ok on confirmBox");
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickOkConfirmBox()),"the click miss in Ok, in the confirm box");
        MyLogger.info("//6.2 obtain the result of your selection");
        MyLogger.info("Obtain the answer of the clicked actions");
        String selection = String.valueOf(objAlertsPage.confirmBoxGetText());
        Assert.assertEquals(selection,"You selected Ok","Compare the button you click on alert box");
        MyLogger.info("Click on prompt button");
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickOnPromptButton()),"the click miss on the prompt button");
        MyLogger.info("//8.1 Enter Random generated text and click ok");
        MyLogger.info("Send a random util to the prompt box"+ nameRandom);
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.sendKeysPromptBox(nameRandom).click()));
        Assert.assertEquals(objAlertsPage.promptBoxGetText(),"You entered "+nameRandom,"Compare the text enter on the prompt box");
        MyLogger.info("End of the AlertsPage test - Browser Quit");
    }
}
