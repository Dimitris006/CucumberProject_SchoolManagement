package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ViceDean_LessonManagementPage;
import utilities.Driver;
import utilities.WaitUtils;

public class US08_StepDefs {
    ViceDean_LessonManagementPage lessonManagement = new ViceDean_LessonManagementPage();
    Faker faker = new Faker();
    public static String lessonNameTrack;
    /**
     * ====================================================================
     *                         TC_01
     * ====================================================================
     */
    @When("Education Term Management page loads up")
    public void education_term_management_page_loads_up() {
        Assert.assertTrue(lessonManagement.lessonsTab.isDisplayed());
        Assert.assertTrue(lessonManagement.educationTermTab.isDisplayed());
        WaitUtils.waitFor(1);
    }
    @Then("Vice Dean clicks on the Lessons tab")
    public void vice_dean_clicks_on_the_lessons_tab() {
        lessonManagement.lessonsTab.click();
        WaitUtils.waitFor(1);
    }
    @Then("Vice Dean types the lesson {string} into Lesson name field")
    public void vice_dean_types_the_lesson_name_into_lesson_name_field(String lessonName) {

        lessonName = provideRandomName();
        lessonManagement.lessonName.sendKeys(lessonName);
        System.out.println(lessonName);
        lessonNameTrack = lessonName;

        WaitUtils.waitFor(1);
    }

    /**
     * ====================================================================
     *                         TC_02
     * ====================================================================
     */
    @And("Vice Dean clicks on the Compulsory checkbox")
    public void viceDeanClicksOnTheCompulsoryCheckbox() {
        lessonManagement.checkboxCompulsory.click();

        //Assert that the checkbox is clicked
        WaitUtils.waitFor(1);
        Assert.assertTrue(lessonManagement.checkboxCompulsory.isSelected());
    }

    /**
     * ====================================================================
     *                         TC_03
     * ====================================================================
     */

    @And("Vice Dean adds Credit Score")
    public void viceDeanAddsCreditScore() {
        int randomNum = faker.number().numberBetween(20, 100);
        lessonManagement.creditScore.sendKeys(String.valueOf(randomNum));
        WaitUtils.waitFor(1);
    }

    public String provideRandomName() {
        String name = faker.name().firstName();
        String id = String.valueOf(faker.number().numberBetween(1000, 9999));

        return name + id;
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
        System.out.println("Driver closed...");
    }


}
