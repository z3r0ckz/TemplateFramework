package Pages;

import Base.BaseElement;
import Base.BaseForm;
import Base.Wrappers.*;
import Utils.AlertsUtils;
import Utils.BrowserUtils;
import Utils.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlertsPage extends  BaseForm{
        //-----------------------Constructor---------------------------------
    public AlertsPage(By uniqueFormLocator, String formName) {
        super(uniqueFormLocator, formName);
    }
        //-------------------------Locator Objects Alerts -----------------------------------
    private final Button buttonAlerts =
             new Button(By.xpath("//span[contains(text(),'Alerts')]"),"buttonAlerts");
    private final Button clickMeAlertButton =
            new Button(By.id("alertButton"),"Click me - Alert button");
    private final Button clickMeConfirmBoxButton =
            new Button(By.id("confirmButton"),"Click me - Confirm box");
    private final Button confirmSelection =
            new Button(By.id("confirmResult"),"Confirm box Text");
    private final Button promptButton =
            new Button (By.id("promptButton"),"Click me - Prompt button");
    private final TextBox promptTextEntered =
            new TextBox (By.id("promptResult"),"Prompt text entered");

    //-------------------------Locator Objects Frames-----------------------------------
    private final Button buttonFrames =
            new Button(By.xpath("//span[contains(text(),'Frames')]"),"buttonFrames");
    private final Button buttonNestedFrames =
            new Button(By.xpath("//span[contains(text(),'Nested Frames')]"),"buttonNestedFrames");
    private final Frame parentNestedFrame =
            new Frame(By.id("frame1"),"Parent Nested Frame");
    private final Frame childNestedFrame =
            new Frame(By.tagName("iframe"),"Child Nested Frame");
    private final Frame frameBody =
            new Frame (By.xpath("//body"), "frameBody");
    private final Frame upperFrame =
            new Frame (By.id("frame1"),"upper Frame");
    private final Frame lowerFrame =
            new Frame (By.id("frame2"),"lower Frame");

    //-------------------------Locator Objects Browser Windows-----------------------------------
    private final Button buttonBrowserWindows =
            new Button (By.xpath("//span[contains(text(),'Browser Windows')]"),"buttonBrowserWindows");
    private final Button buttonNewTab =
            new Button(By.id("tabButton"),"button NewTab");

    //------------------------Locators left Panel----------------------------
    public By clickOnAccordionPosition(int number) {
        List<WebElement> listAccordion = leftPanelAccordion.getElements(By.xpath("//div[contains(@class, 'element-group')]"));
        listAccordion.get(number).click();
        MyLogger.info("Click on selected button (accordion) of the left panel");
        return  null;
    }
    private final Button buttonElements_Links =
            new Button(By.xpath("//span[contains(text(),'Links')]"),"button Element Links");
    private final Button leftPanelAccordion =
            new Button(By.className("accordion"),"leftPanelAccordion");
    private final Label links_HomeLink =
            new Label (By.id("simpleLink"),"simpleLink Home");

    //---------------------------------Start of the Alert methods-------------------------------
    public By clickAlertButton() {
        return buttonAlerts.click();
    }
     public By clickMeAlertButton(){
        return clickMeAlertButton.click();
     }
     public By clickOkSimpleAlert(){
         AlertsUtils.simpleAlert(clickMeAlertButton);
         return clickMeAlertButton.click();
     }
     public By clickMeConfirmBoxButton(){
        return clickMeConfirmBoxButton.click();
     }
    public By clickOkConfirmBox(){
        AlertsUtils.simpleAlert(clickMeConfirmBoxButton);
        return clickMeAlertButton.click();
    }
    public String confirmBoxGetText(){
        return confirmSelection.getText();
    }
    public  By clickOnPromptButton()  {
        return promptButton.click();
    }
    public BaseElement sendKeysPromptBox(String text){
        AlertsUtils.promptAlertTypeText(promptButton,text);
        return promptButton;
    }
    public String promptBoxGetText(){
        return promptTextEntered.getText();
    }
    //---------------------------------Start of the Frames methods-------------------------------
    public By clickNestedFramesButton() {
        return buttonNestedFrames.click();
    }
    public String parentNestedFrameGetText()  {
        BrowserUtils.switchToFrame(parentNestedFrame.getElement());
        return frameBody.getText();
    }
    public String childNestedFrameGetText(){
        BrowserUtils.switchToFrame(childNestedFrame.getElement());
        return frameBody.getText();
    }
    public void returnParentFrame()  {
        MyLogger.info("Switch to Parent Frame");
        BrowserUtils.switchToParentFrame();
    }
    public By clickFrameButton() {
        return buttonFrames.click();
    }

    public String upperFrameGetText() {
        BrowserUtils.switchToFrame(upperFrame.getElement());
        MyLogger.info("Switch active frame (upper frame)");
        return frameBody.getText();
    }
    public String lowerFrameGetText(){
        BrowserUtils.switchToFrame(lowerFrame.getElement());
        MyLogger.info("Switch active frame (lower frame)");
        return frameBody.getText();
    }
    //--------------------------Start of Window Handle methods-----------------
    public By clickBrowserWindowsButton() {
        return buttonBrowserWindows.click();
    }
    public By clickMeNewTabButton() {
        return buttonNewTab.click();
    }

    //------------------------- Methods Left Panel
    public By clickHomeLink() {
        return links_HomeLink.click();
    }
    public By clickElements_Links() {
        return buttonElements_Links.click();
    }
}
