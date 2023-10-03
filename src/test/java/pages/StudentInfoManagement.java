package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudentInfoManagement {
    public StudentInfoManagement(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div[1]/div/h3")
    public WebElement studentInfoManagementPage;

    @FindBy(xpath = "//*[@id='lessonId']")
    public WebElement chooseLesson;

    @FindBy(xpath = "//*[@id='studentId']")
    public WebElement chooseStudent;

    @FindBy(xpath = "//*[@id='educationTermId']")
    public WebElement chooseEducationTerm;

    @FindBy(xpath = "//*[@id='absentee']")
    public WebElement absentee;

    @FindBy(xpath = "//*[@id='midtermExam']")
    public WebElement midtermExam;

    @FindBy(xpath = "//*[@id='finalExam']")
    public WebElement finalExam;

    @FindBy(xpath = "//*[@id='infoNote']")
    public WebElement infoNote;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div/div/form/div/div[8]/div/button")
    public WebElement submitButton1;

    @FindBy(xpath = "//*[@id='root']/div/main/div/div[1]/div[3]/div/h5")
    public WebElement studentInfoList;

    @FindBy(xpath = "//*[(text()='Menu')]")
    public WebElement menuButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/a[1]")
    public WebElement studentInfoManagementButton;
}
