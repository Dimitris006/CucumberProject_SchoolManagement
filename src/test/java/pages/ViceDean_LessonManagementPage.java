package pages;

import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.WaitUtils;

import java.util.List;

public class ViceDean_LessonManagementPage {
    public ViceDean_LessonManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Education Term tab in the /lesson site for ViceDean
    @FindBy(css = "#controlled-tab-example-tab-educationTerm")
    public WebElement educationTermTab;

    //lessons tab in the /lesson site for ViceDean
    @FindBy(css = "#controlled-tab-example-tab-lessonsList")
    public WebElement lessonsTab;

    @FindBy(xpath = "//button[.='Lessons']")
    public WebElement lessonsTab1;

    //lesson Program in the /lesson site for ViceDean
    @FindBy(css = "#controlled-tab-example-tab-lessonProgram")
    public WebElement lessonProgram;

    /************************************************************************
     * Below are elements for the Lesson Management area - EDUCATION TERM TAB
     ************************************************************************/

    //Select input for education term
    @FindBy(css = "#term")
    public WebElement selection_educationTerm;

    //Select input for start date
    //send key in this format: dd/mm/yyyy
    @FindBy(css = "#startDate")
    public WebElement selection_startDate;

    //Select input for end date
    //send key in this format: dd/mm/yyyy
    @FindBy(css = "#endDate")
    public WebElement selection_endDate;

    //Select input for last registration date
    //send key in this format: dd/mm/yyyy
    @FindBy(css = "#lastRegistrationDate")
    public WebElement selection_lastRegistrationDate;

    //Select input for submit button
    @FindBy(xpath = "(//div//button[.='Submit']) [1]")
    public WebElement lessonManagementSubmitButton;

    /************************************************************************
     * Below are elements for the Lesson Management area - LESSONS TAB
     ************************************************************************/

    public String trackLessonName = null;

    //Text field input for lesson name
    @FindBy(css = "#lessonName")
    public WebElement lessonName;

    //checkbox input for compulsory
    @FindBy(css = "#compulsory")
    public WebElement checkboxCompulsory;

    //Text field input for Credit Score
    @FindBy(css = "#creditScore")
    public WebElement creditScore;

    //Submit Add Lesson in LESSON TAB
    @FindBy(xpath = "(//form)[2]//button")
    public WebElement lessonsAddLessonSubmitButton;

    /**
     * How to use the lessonListFinalPage WebElement
     * And the findLessonInLessonList() method
     * -
     * 1. use lessonListFinalPage to go to the last page
     * 2. then use findLessonInLessonList() passing the name to the method
     * Since added lessons always go to the last page, you can easily locate this way
     */
    //filter to the last page of the Lesson List table
    @FindBy(xpath = "(//a[@class='page-link']//span[.='»']) [2]")
    public WebElement lessonListFinalPage;

    //Find the WebElement for lesson from the Lesson List table
    //Note: this is in trial at the moment. Might not work!
    //UPDATE: THIS METHOD WORKS. USE IT!
    //CAUTION -- you may need to use JSUtils to scroll element into view first
    public WebElement findLessonInLessonList(String lessonNameInTable) {

        return Driver.getDriver().findElement(By.xpath(
                "(//table)[2]//tbody//td[.='"+lessonNameInTable+"']"
        ));
    }

    /**
     *
     * @param element -> use the findLessonInLessonList here
     */

    // >>>>>>>>>>>>Still Testing this! Don't delete <<<<<<<<<<<<<

    public void findAndDeleteLesson(WebElement element) {
        List<WebElement> getElements = Driver.getDriver().findElements(By.xpath("(//table)[2]//tbody//tr//td"));

        for (WebElement currentElement : getElements) {
            System.out.println(element.getText());
            System.out.println("Hi");
        }
    }

    /************************************************************************
     * Below are elements for the Lesson Management area - LESSONS PROGRAM TAB
     ************************************************************************/

    //Select input choose lesson
    @FindBy(css = ".css-19bb58m input")
    public WebElement getSelectionChooseLesson;

    //Select input choose education term
    @FindBy(css = "#educationTermId")
    public WebElement getSelectionChooseEducationTerm;

    //Select input choose day
    @FindBy(css = "#day")
    public WebElement getSelectionChooseDay;

    //start time
    //NOTE: must send keys in this format: --:--  where the last part is am or pm
                                    //e.g. 21:00
    @FindBy(css = "#startTime")
    public WebElement startTime;

    //Stop Time
    //NOTE: must send keys in this format: --:--  where the last part is am or pm
                                    //e.g. 21:00
    @FindBy(css = "#stopTime")
    public WebElement stopTime;

    //Submit Lesson Program
    @FindBy(xpath = "//a[.='Lesson Management']")
    public WebElement submitLessonButton;







}
