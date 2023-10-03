package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.CommonLocator;
import utilities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static base_url.BaseUrl.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;

public class US06_StepDefs {
    CommonLocator commonLocator =new CommonLocator();
    ResultSet resultSet;
    Response response;
    JsonPath jsonPath;
    List<Object>actualData;
    private static Integer userId;
    private static String actUsername;
    private static String actName;
    private static String actSurname;
    private static String actSSN;
    private static String actBirthDate;
    private static String actBirthPlace;
    private static String actPhoneNumber;
    private static String actGender;



    //    @Then("verify Vice Dean created successfully confirmation message")
//    public void verifyViceDeanCreatedSuccessfullyConfirmationMessage() {
//        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
//        assertTrue(commonLocator.confirmationMessage.getText().contains("Vice dean Saved"));
//    }
    @Then("enter date of Birth")
    public void enterDateOfBirth() {
        dateOfBirth = "01-05-1990";
        reverseDateOfBirth = "1990-05-01";
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            // Parse the original date into a Date object
            Date date = inputDateFormat.parse(dateOfBirth);

            // Create a new SimpleDateFormat object to format the date in "yyyy-MM-dd" format
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date in the desired format
            formattedDate = outputDateFormat.format(date);
        } catch (ParseException e) {
            // Handle any parsing errors here
            e.printStackTrace();
        }
        fakerDateOfBirth = "01/05/1990";
        commonLocator.dateOfBirth.sendKeys(fakerDateOfBirth);

    }

    @Then("verify user name should contains at least four characters")
    public void verifyUserNameShouldContainsAtLeastFourCharacters() {
        WaitUtils.waitFor(3);
        try{
            assertTrue(BrowserUtils.alertText().contains("at least 4 characters"));
        }catch (Exception e){
            //exception handling
        }
    }

    @Then("verify Vice Dean is created successfully confirmation message")
    public void verifyViceDeanIsCreatedSuccessfullyConfirmationMessage() {
        assertTrue(commonLocator.confirmationMessage.isDisplayed());
    }

    @Given("send get ViceDean request on API")
    public void sendGetViceDeanRequestOnAPI() {
        spec.pathParams("first","vicedean","second","getAll");
        response=given(spec).get("{first}/{second}");
    }

    @Then("filter ViceDean Data using username and validate")
    public void filterViceDeanDataUsingUsernameAndValidate() {
        String gender="MALE";
        jsonPath = response.jsonPath();
        List<String> viceDeanData = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}");

        actUsername = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.username").get(0).toString();
        actName = jsonPath.getList("findAll{it.ssn=='" + fakeSsn+ "'}.name").get(0).toString();
        actSurname = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.surname").get(0).toString();
        actBirthDate = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.birthDay").get(0).toString();
        actBirthPlace = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.birthPlace").get(0).toString();
        actPhoneNumber = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.phoneNumber").get(0).toString();
        actGender = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.gender").get(0).toString();

        actualData=jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}");

        userId= Integer.parseInt(jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.userId").get(0).toString());

        assertEquals(200, response.statusCode());
        assertEquals(fakerUsername, actUsername);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(reverseDateOfBirth, actBirthDate);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals(gender, actGender);
    }

    @Given("send A  ViceDean Delete request with username on API")
    public void sendAViceDeanDeleteRequestWithUsernameOnAPI() {
        spec.pathParams("first","vicedean","second","delete","third",userId);
        response=given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("body must be empty with non existing username")
    public void bodyMustBeEmptyWithNonExistingUsername() {
        assertEquals(200,response.statusCode());
        assertTrue(response.getBody().asString().contains("Vice dean Deleted"));
    }

    @Given("get Vice_Dean Data by username")
    public void getVice_DeanDataByUsername() throws SQLException {
        String query = "select * from vice_dean where username = '" + fakerUsername + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();
    }

    @Then("validate  Vice_Dean on database")
    public void validateVice_DeanOnDatabase() throws SQLException {
        actUsername = resultSet.getString("username");
        actName = resultSet.getString("name");
        actSurname = resultSet.getString("surname");
        actBirthPlace = resultSet.getString("birth_place");
        actGender = resultSet.getString("gender");
        actBirthDate = resultSet.getString("birth_day");
        actPhoneNumber = resultSet.getString("phone_number");
        actSSN = resultSet.getString("ssn");


        assertEquals(fakeSsn, actSSN);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
        assertEquals(reverseDateOfBirth, actBirthDate);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("0", actGender);

    }

    @And("close the database connection")
    public void closeTheDatabaseConnection() {
        DBUtils.closeConnection();
    }
}