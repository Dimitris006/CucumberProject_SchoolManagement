package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.WaitUtils;
import pages.CommonLocator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;

public class US22_StepDefs {
    CommonLocator commonLocator = new CommonLocator();
    Response response;
    private static Integer adminID;

   @Given("verify admin created successfully confirmation message")
    public void verify_admin_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Admin saved"));
    }

    @Given("send get All Admin request on API")
    public void sendGetAllAdminRequestOnAPI() {
        spec.pathParams("first", "admin", "second", "getAll").queryParam("size", "10000");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }


    @Then("validate admin data")
    public void validate_admin_data() {
        JsonPath jsonPath = response.jsonPath();
        List<String> adminData = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}");
        System.out.println("adminData = " + adminData);
        String actUsername = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.username").get(0).toString();
        String actName = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.name").get(0).toString();
        String actSurname = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.gender").get(0).toString();
        String actSsn = jsonPath.getList("content.findAll{it.username=='" + fakerUsername + "'}.ssn").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals(fakerUsername, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(reverseDateOfBirth, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("FEMALE", actGender);
    }

    @Then("get adminID from API")
    public void getAdminIDFromAPI() {
        String adminID_String = response.jsonPath().getList("content.findAll{it.username=='"+fakerUsername+"'}.id").get(0).toString();
        adminID = Integer.parseInt(adminID_String);
        System.out.println("adminID = " + adminID);
    }

    @Then("delete admin using adminID")
    public void deleteAdminUsingAdminID() {
        spec.pathParams("first", "admin", "second", "delete", "third", adminID);
        response = given(spec).delete("{first}/{second}/{third}");
    }

    @And("validate admin data deleted")
    public void validateAdminDataDeleted() {
        System.out.println("response.statusCode() = " + response.statusCode());

        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("Admin deleted Successful"));

    }

    @Then("enter your date of birth")
    public void enter_your_date_of_birth() {
        dateOfBirth = "01-05-1990";
        reverseDateOfBirth = "1990-05-01";
//        commonLocator.dateOfBirth.sendKeys(dateOfBirth);
//        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            // Parse the original date into a Date object
//            Date date = inputDateFormat.parse(dateOfBirth);
//
//            // Create a new SimpleDateFormat object to format the date in "yyyy-MM-dd" format
//            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            // Format the date in the desired format
//            formattedDate = outputDateFormat.format(date);
//        } catch (ParseException e) {
//            // Handle any parsing errors here
//            e.printStackTrace();
//        }
        fakerDateOfBirth = "01/05/1990";
        commonLocator.dateOfBirth.sendKeys(fakerDateOfBirth);
    }
}
