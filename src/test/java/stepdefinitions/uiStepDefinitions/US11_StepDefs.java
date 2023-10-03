package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ViceDean_LessonManagementPage;
import utilities.ActionUtils;
import utilities.MediaUtils;
import utilities.WaitUtils;
import java.io.IOException;
public class
US11_StepDefs {
    ViceDean_LessonManagementPage viceDean_lessonManagementPage = new ViceDean_LessonManagementPage();

    //US11_TC01
    @When("Management page loads up")
    public void management_page_loads_up() {
        Assert.assertTrue(viceDean_lessonManagementPage.lessonProgram.isDisplayed());
        WaitUtils.waitFor(1);
    }
    @Then("click Lesson Program")
    public void click_lesson_program() {
        viceDean_lessonManagementPage.lessonProgram.click();
        WaitUtils.waitFor(3);
    }
    @Then("scroll down until see Lesson Program")
    public void scroll_down_until_see_lesson_program() {
        ActionUtils.scrollDownActions();
        WaitUtils.waitForVisibility(viceDean_lessonManagementPage.lessonProgram, 1);
        Assert.assertTrue(viceDean_lessonManagementPage.lessonProgram.isDisplayed());
        WaitUtils.waitFor(3);

    }
    @Then("verify Lesson, Day, Start Time and Stop Time created are visible")
    public void verifyLessonDayStartTimeAndStopTimeCreatedAreVisible() {
        Assert.assertTrue(viceDean_lessonManagementPage.lessonsTab.isDisplayed());
        Assert.assertTrue(viceDean_lessonManagementPage.stopTime.isDisplayed());
        Assert.assertTrue(viceDean_lessonManagementPage.startTime.isDisplayed());
        Assert.assertTrue(viceDean_lessonManagementPage.getSelectionChooseDay.isDisplayed());
        WaitUtils.waitFor(1);
    }
    //US11_TC02
    @And("verify update Button exists")
    public void verifyUpdateButtonExists() {
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //US11_TC03
    @Then("verify Delete button is visible")
    public void verifyDeleteButtonIsVisible() {

            try {
                MediaUtils.takeScreenshotOfTheEntirePage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



}
















