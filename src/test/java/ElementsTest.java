import DTO.UserDTO;
import Pages.ElementsPage;
import Pages.MainPage;
import Utils.BrowserUtils;
import Utils.MyLogger;
import Utils.WaitsUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ElementsTest extends BaseTest{
    protected MainPage objMainPage = new MainPage(PageLocator_Main,"MainPage");
    protected ElementsPage objElementsPage = new ElementsPage(PageLocator_Elements,"Elements Page");
    public ElementsTest() throws IOException {
        super(new WaitsUtil());
    }
    @Test (priority = 1)
    public void tableTest(){
        MyLogger.info("Start of the Elements test");
        BrowserUtils.scrollFindLocator(PageLocator_Elements);
        objMainPage.clickElements();
        MyLogger.info("Check if element Page is open");
        Assert.assertTrue(objElementsPage.isPageOpen(PageLocator_Elements),"The Elements page isn't open");
        MyLogger.info("wait to click on Web Tables Button");
        BrowserUtils.scrollFindLocator(PageLocator_Elements);
        Assert.assertFalse(waits.waitElementToBeClicked(objElementsPage.clickWebTableButton()),"The click on web table miss");
        MyLogger.info("Web Table button was clicked");
    }
    @Test (dataProvider = "testDataFillForm", priority = 2)
    public void fillFormTest
            (UserDTO userDTO) {
        Assert.assertFalse(waits.waitElementToBeClicked(objElementsPage.clickAddElementWebTable()),"The click on ADD button on teh register form fail");
        MyLogger.info("ADD button on web table was clicked - and registration form is open");
        Assert.assertTrue(waits.waitElementDisplayed(objElementsPage.registrationFormOpen()),"The form in close");
        MyLogger.info("Enter Data for users");
        objElementsPage.fillRegisterForm(userDTO);
        MyLogger.info("The Register form was fill with users in the testDataRegistration.json");
        Assert.assertFalse(waits.waitElementToBeClicked(objElementsPage.clickSummitButtonOnRegistration()),"The click on summit button fail");
        MyLogger.info("Click on summit button to register the new user");
        String formUserData = String.valueOf((userDTO));
        Assert.assertEquals(objElementsPage.getTableTextInPosition(3),formUserData,"The formData is different from the input data");
        MyLogger.info("Check if the data provided was the same on the table");
        MyLogger.info("Delete User");
        int recordsNumber = objElementsPage.getRecordsSize();
        MyLogger.info("Obtain record size to delete a user ");
        objElementsPage.deleteUserInPosition(3);
        int newRecordsSize = objElementsPage.getRecordsSize();
        Assert.assertNotEquals(recordsNumber,newRecordsSize, "Same number of records");
        Assert.assertTrue(objElementsPage.getTableTextInPosition(3).isEmpty(), "Data still available");

    }
    @DataProvider(name="testDataFillForm")
    public Object[][] dataFeed() {
        List<Object> userDataList = testdata.getList("userData");
        Object[][] userData = new Object[userDataList.size()][6];
        for (int i = 0; i < userDataList.size(); i++) {
            Map<String, Object> userDataMap = (Map<String, Object>) userDataList.get(i);
            userData[i][0] = userDataMap.get("firstName");
            userData[i][1] = userDataMap.get("lastName");
            userData[i][2] = userDataMap.get("email");
            userData[i][3] = userDataMap.get("age").toString();
            userData[i][4] = userDataMap.get("salary").toString();
            userData[i][5] = userDataMap.get("department");
        }
        return userData;
    }
}
