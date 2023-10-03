package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@href='/register']")
    public WebElement registerLink;

    @FindBy(xpath = "(//input)[2]")
    public WebElement surname;

    @FindBy(xpath = "(//input)[3]")
    public WebElement birthPlace;

    @FindBy(xpath = "(//input)[4]")
    public WebElement phoneNumber;

    @FindBy(xpath = "(//input)[5]")
    public WebElement femaleRadioButton;
    @FindBy(xpath = "//input[@value='MALE']")
    public WebElement maleRadioButton;

    @FindBy(xpath = "(//input)[7]")
    public WebElement dateOfBirth;

    @FindBy(xpath = "(//input)[8]")
    public WebElement ssn;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(xpath = "(//button)[3]")
    public WebElement registerButton;
    @FindBy(xpath = "//button[text()='Register']")
    public WebElement registerButton1;

    @FindBy(xpath = "//div[contains(text(), 'Guest User registered.')]")
    public WebElement userRegisteredText;
    //div[.="Guest User registered"

    @FindBy(xpath = "//div[contains(text(), 'Required')]")
    public WebElement requiredMessage;

    @FindBy(xpath = "//div[contains(text(), 'Please enter valid phone number')]")
    public WebElement invalidPhoneNumberMessage;
    @FindBy(xpath = "//div[contains(text(), 'Please enter valid SSN number')]")
    public WebElement invalidSSNNumberMessage;

    @FindBy(xpath = "//div[contains(text(), 'At least 8 characters')]")
    public WebElement invalidPassword;
    @FindBy(id="name")
    public WebElement nameInput;
    @FindBy(id= "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;




}