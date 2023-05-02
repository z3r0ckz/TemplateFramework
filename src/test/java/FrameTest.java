
import Pages.MainPage;
import Pages.AlertsPage;
import Utils.BrowserUtils;
import Utils.MyLogger;
import Utils.WaitsUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FrameTest extends BaseTest{
    protected MainPage objMainPage = new MainPage(PageLocator_Main,"MainPage");
    protected AlertsPage objAlertsPage = new AlertsPage(PageLocator_Alerts ,"AlertsPage");

    public FrameTest() throws IOException {
        super(new WaitsUtil());
    }
    @Test(priority = 1)
    public void framesTestCases()  {
        MyLogger.info("Start of the Frames test");
        objMainPage.clickAlerts();
        MyLogger.info("Check if alerts Page is open");
        Assert.assertTrue(objAlertsPage.isPageOpen(PageLocator_Alerts),"The Alerts page isn't open");
        //2 - Click on Nested Frames button
        BrowserUtils.scrollFindLocator(PageLocator_Alerts);
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickNestedFramesButton()),"The click on the nested frames button fail");
        MyLogger.info(" Click on Nested Frame Button on left panel");
        //2.1 - Obtain the text on the Parent and child Frames
        String parentFrame = String.valueOf(objAlertsPage.parentNestedFrameGetText());
        String childFrame = String.valueOf(objAlertsPage.childNestedFrameGetText());
        MyLogger.info("Obtain the text of the nested frames");
        Assert.assertEquals(parentFrame+" & "+childFrame,"Parent frame & Child Iframe","the text in nested frames is not equal");
        //return to the parent frame
        objAlertsPage.returnParentFrame();
        //return to the main frame
        objAlertsPage.returnParentFrame();
        //3.1 Click on the frames button on the left panel
        MyLogger.info("Click on Frames button on left panel");
        BrowserUtils.scrollFindLocator(PageLocator_Alerts);
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickFrameButton()),"the click in frame button fail");
        //3.2 Compare the message on the upper frame and lower frame
        MyLogger.info("Obtain the text of the separated frames");
        String upperFrame = String.valueOf(objAlertsPage.upperFrameGetText());
        //return to the main frame
        objAlertsPage.returnParentFrame();
        String lowerFrame = String.valueOf(objAlertsPage.lowerFrameGetText());
        Assert.assertEquals(upperFrame,lowerFrame,"The message of the upper frame and the lower frame is not the same");
        MyLogger.info("End of the Frames Test");
    }
}
