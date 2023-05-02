import A1QA.Browser.Browser;
import Pages.AlertsPage;
import Pages.MainPage;
import Utils.BrowserUtils;
import Utils.MyLogger;
import Utils.WaitsUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class HandlesTest extends  BaseTest{
    protected MainPage objMainPage = new MainPage(PageLocator_Main,"MainPage");
    protected AlertsPage objAlertsPage = new AlertsPage(PageLocator_Alerts ,"AlertsPage");
    public HandlesTest() throws IOException {
        super(new WaitsUtil());
    }
    @Test(priority = 1)
    public void framesTestCases(){
        MyLogger.info("Start of the Handle test");
        objMainPage.clickAlerts();
        MyLogger.info("Check if Alerts Page is open");
        Assert.assertTrue(objAlertsPage.isPageOpen(PageLocator_Alerts),"The alerts page isn't open");
        MyLogger.info("Click on Browser Windows button on the left panel");
        BrowserUtils.scrollFindLocator(PageLocator_Alerts);
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickBrowserWindowsButton()),"The click fail on browser windows button");
        MyLogger.info("Click on NewTab button ");
        System.out.println("Actual tab index"+BrowserUtils.getActualIndexTab());
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickMeNewTabButton()),"the click miss in Click me new tab button");
        BrowserUtils.changeActiveTab();
        MyLogger.info("Obtain the index of the new tab"+BrowserUtils.getActualIndexTab());
        MyLogger.info(" Close current Tab");
        Browser.Driver().close();
        BrowserUtils.SwitchToTabNumber(0);
        MyLogger.info("Switch to tab 0 and verify we're on the correct page");
        MyLogger.info("//check if we are in the correct page browserWindows");
        Assert.assertTrue(objAlertsPage.isPageOpen(PageLocator_BrowserWindows));
        for (By by : Arrays.asList(objAlertsPage.clickOnAccordionPosition(0), objAlertsPage.clickElements_Links())) {
            Assert.assertFalse(waits.waitElementToBeClicked(by),"The click fail in element button");
        }
        MyLogger.info("Click on Elements -> Links");
        Assert.assertFalse(waits.waitElementToBeClicked(objAlertsPage.clickHomeLink()),"the click fail in home link  ");
        MyLogger.info("Click on home button");
        MyLogger.info("//7 - Resume previous tab");
        BrowserUtils.SwitchToTabNumber(0);
        Assert.assertTrue(objAlertsPage.isPageOpen(PageLocator_Links));
        MyLogger.info("Switch to links webpage and verify with the page locator");
    }
}
