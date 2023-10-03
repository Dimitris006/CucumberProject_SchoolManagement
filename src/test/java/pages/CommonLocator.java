package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonLocator {
    // this page is created for common locators for teacher creation, student creation, dean creation
    public CommonLocator(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnField;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameField;

    @FindBy (xpath = "//input[@id='birthDay']")
    public WebElement dateOfBirth;

    @FindBy(linkText = "Student Management")
    public WebElement studentManagementLink;

    @FindBy(xpath = "//button[(text()='Menu')]")
    public WebElement menuButton;

    @FindBy(linkText = "Logout")
    public WebElement logOutButton;

    @FindBy(xpath = "//button[.='Yes']")
    public WebElement yesButton;

    @FindBy(xpath = "//*[@id='offcanvasNavbar-expand-lg']/div[2]/div/a[11]")
    public WebElement guestUser;

    @FindBy(xpath = "//*[@class='fw-bold p-3 card-header']")
    public WebElement guestUserList;

    @FindBy(xpath = "//*[@class='fa-solid fa-trash']")
    public WebElement deleteUserGuest;

    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div/div/div/div[1]/table/tbody/tr[2]/td[5]/span/button")
    public WebElement getDeleteUserGuestSuccessfully;


    @FindBy(xpath = "//*[@placeholder='Name']")
    public WebElement name;
    @FindBy(xpath = "//*[@placeholder='Surname']")
    public WebElement surname;
    @FindBy(xpath = "//*[@placeholder='Birth Place']")
    public WebElement birthplace;
    @FindBy(xpath = "//*[@value='MALE']")
    public WebElement genderMale;
    @FindBy(xpath = "//*[@value='FEMALE']")
    public WebElement genderFemale;
    @FindBy(xpath = "//*[@placeholder='Password']")
    public WebElement passwordField;
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement confirmationMessage;
    @FindBy(xpath = "//a[@class='page-link' and contains(., 'Last')]")
    public WebElement goLastPageButton;
    @FindBy(xpath = "//*[text()='One number']")
    public WebElement passwordWithoutNumberErrorMessage;
    @FindBy(xpath = "//*[.='One lowercase character']")
    public WebElement passwordWithoutLowerCaseErrorMessage;
    @FindBy(xpath = "//*[.='One uppercase character']")
    public WebElement passwordWithoutUpperCaseErrorMessage;
    @FindBy(xpath = "//*[.='At least 8 characters']")
    public WebElement passwordLessCharErrorMessage;

    @FindBy(linkText = "Lesson Management")
    public WebElement lessonManagementLink;

    @FindBy(xpath = "//*[@id=\"27\"]/div[1]/div[2]")
    public WebElement existingEmailMasage;

    @FindBy(xpath = "//*[@role='alert' and .='Please select advisor teacher']")
    public WebElement errorMessageAdvisorTeacher;



}
