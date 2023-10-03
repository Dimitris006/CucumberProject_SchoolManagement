package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CommonLocator;
import pages.ViceDeanLessonProgram;
import pages.ViceDean_AdminManagementPage;
import pages.ViceDean_LessonManagementPage;
import utilities.BrowserUtils;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.sql.ResultSet;
import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;

public class US10_StepDef {

    ViceDeanLessonProgram viceDeanLessonProgram = new ViceDeanLessonProgram();
    ViceDean_LessonManagementPage viceDeanLessonManagementPage = new ViceDean_LessonManagementPage();
    ViceDean_AdminManagementPage viceDeanAdminManagementPage = new ViceDean_AdminManagementPage();
    CommonLocator commonLocator = new CommonLocator();
    Faker faker = new Faker();
    Response response;


    @Given("click lesson management")
    public void click_lesson_management() {
        JSUtils.clickWithTimeoutByJS(commonLocator.lessonManagementLink);
    }

    @Given("click lesson program")
    public void click_lesson_program() {
        JSUtils.clickWithTimeoutByJS(viceDeanLessonProgram.lessonProgramSeccion);
    }

    @Given("choose Lesson")
    public void choose_lesson() {
        viceDeanLessonManagementPage.getSelectionChooseLesson.sendKeys("Selenium" + Keys.ENTER);
        WaitUtils.waitFor(2);
    }

    @Given("choose education term")
    public void choose_education_term() {
        BrowserUtils.selectByVisibleText(viceDeanLessonManagementPage.getSelectionChooseEducationTerm, "FALL_SEMESTER");
        WaitUtils.waitFor(2);
    }

    @Given("chose day")
    public void chose_day() {
        BrowserUtils.selectByVisibleText(viceDeanLessonManagementPage.getSelectionChooseDay, "MONDAY");
        WaitUtils.waitFor(3);
    }

    @Given("choose start time")
    public void choose_start_time() {
        viceDeanLessonManagementPage.startTime.sendKeys("13:00");
    }

    @Given("choose stop time")
    public void choose_stop_time() {
        viceDeanLessonManagementPage.stopTime.sendKeys("14:00");
    }

    @And("click submit button on Add Lesson Program")
    public void clickSubmitButtonOnAddLessonProgram() {
        viceDeanLessonProgram.addLessonProgSubmitButton.click();
    }


    @Then("verify lesson is created")
    public void verify_lesson_is_created() {
        WaitUtils.waitForVisibility(viceDeanLessonProgram.createdLessonVisible, 5);
    }

    @Then("verify selected courses are visible in lesson program ")
    public void verify_selected_courses_are_visible_in_lesson_program() {
        assertTrue(viceDeanLessonProgram.createdLessonVisible.isDisplayed());
    }

    @Given("choose multiple lessons")
    public void choose_multiple_lessons(){
        viceDeanLessonManagementPage.getSelectionChooseLesson.sendKeys("Selenium" + Keys.ENTER);
        viceDeanLessonManagementPage.getSelectionChooseLesson.sendKeys("JavaScript" + Keys.ENTER);
        viceDeanLessonManagementPage.getSelectionChooseLesson.sendKeys("English" + Keys.ENTER);

        WaitUtils.waitFor(2);


    }
    @Given("choose Lesson EmillyLesson")
    public void choose_lesson_EmillyLesson() {
        viceDeanLessonManagementPage.getSelectionChooseLesson.sendKeys("EmillyLesson" + Keys.ENTER);
        WaitUtils.waitFor(2);
    }
    @Given("Send get all lesson program request on API")
    public void Send_get_all_lesson_program_request_on_api() {
        //https://managementonschools.com/app/lessonPrograms/getAll
        spec.pathParams("first","lessonPrograms","second","getAll");
        response = given(spec).get("{first}/{second}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("lessonPrograms.size()", greaterThan(0)).extract().response();
        // response.prettyPrint();
    }
    @Then("filter lessons programs by id and verify")
    public void filter_lessons_programs_by_id_and_verify() {
        //lessonPrograms/getById/{id}
        response= given(spec).pathParams(
                        "first",
                        "lessonPrograms",
                        "second",
                        "getById",
                        "third",
                        "1081").get("/{first}/{second}/{third}")
                .then()
                .statusCode(200)
                .body("startTime",equalTo("13:00:00"))//when is out of Array we will use equalTo()
                .body("stopTime",equalTo("14:00:00"))
                .body("lessonName.lessonName",hasItem("EmillyLesson"))//when is in the Array we will use hasItem()
                .body("day",equalTo("MONDAY"))
                .extract().response();
        // We use .extract().response() to make the response object accept the assertions we make
        response.prettyPrint();
    }
}