package Pages;
import Base.BaseForm;
import Base.Wrappers.*;
import DTO.UserDTO;
import Utils.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ElementsPage extends BaseForm {
    //-----------------------Constructor---------------------------------
    public ElementsPage( By uniqueFormLocator, String formName)  {
        super( uniqueFormLocator, formName);
    }
    //-------------------------Locator Objects Tables -----------------------------------
    private final Button buttonWebTable =
            new Button(By.xpath("//span[contains(text(),'Web Tables')]"),"buttonWebTables");
    private final Button addButtonWebTable =
            new Button(By.id("addNewRecordButton"),"Add button on web tables");
    private final Form registrationFormOpen =
            new Form(By.id("registration-form-modal"),"Registration form open");
    //------------------------Registration Form Locators-----------------------
    private final TextBox firstNameInForm =
            new TextBox(By.id("firstName"),"first name in Form");
    private final TextBox lastNameInForm =
            new TextBox(By.id("lastName"), "last name in form");
    private final TextBox emailInForm =
            new TextBox(By.id("userEmail"), "user email in Form");
    private final TextBox ageInForm =
            new TextBox(By.id("age"), "age in form");
    private final TextBox salaryInForm =
            new TextBox(By.id("salary"), "salary in form");
    private final TextBox departmentInForm =
            new TextBox(By.id("department"), "department in form");
    private final Button summitButton =
            new Button(By.id("submit"),"Summit Button Registration form");
    private final Table tableList =
            new Table (By.className("rt-tbody"),"tableList");
    private final Button actionButtons =
            new Button(By.className("action-buttons"), "actionButtons");
    //-------------------------Start of the Web Table Methods----------------
    public By clickWebTableButton(){
        MyLogger.info("Click on Web table button");
        return buttonWebTable.click();
    }
    public By clickAddElementWebTable() {
        return addButtonWebTable.click();
    }
    public By registrationFormOpen(){
        return (By) registrationFormOpen.getElement();
    }
    public void fillRegisterForm
    (UserDTO userDTO) {
        MyLogger.info("Fill the registration form");
        firstNameInForm.sendKeys(userDTO.getFirstName());
        lastNameInForm.sendKeys(userDTO.getLastName());
        emailInForm.sendKeys(userDTO.getEmail());
        ageInForm.sendKeys(userDTO.getAge());
        salaryInForm.sendKeys(userDTO.getSalary());
        departmentInForm.sendKeys(userDTO.getDepartment());
    }
    public String getTableTextInPosition(int position) {
        List<WebElement> list = tableList.getElement().findElements(By.className("rt-tr-group"));
        String[] rowText = list.get(position).getText().split("\n");
        MyLogger.info("Get table index ");
        return String.join(",", rowText).trim();
    }
    public By clickSummitButtonOnRegistration() {
        return summitButton.click();
    }
    public void deleteUserInPosition(int position)  {
        List<WebElement> deleteButtons = actionButtons.getElement().findElements(By.xpath("//*[starts-with(@id,'delete-record-')]"));
        deleteButtons.get(position).click();
        MyLogger.info("Delate user from the table");
    }
    public int getRecordsSize() {
        MyLogger.info("Get the size of elements inside the register form");
        return actionButtons.getElements(By.className("element-group")).size();
    }
}
