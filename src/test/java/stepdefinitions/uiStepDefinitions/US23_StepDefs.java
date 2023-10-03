package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.CommonLocator;
import pages.CreateViceDeanPage;
import pages.DeanCreatePage;
import utilities.DBUtils;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;

public class US23_StepDefs {



    Response response;
    ResultSet resultSet;
    Connection connection;

    Faker faker = new Faker();
    CommonLocator commonLocator = new CommonLocator();
    public static String vicedeanbirth_day;

    CreateViceDeanPage createViceDeanPage=new CreateViceDeanPage();

    @Then("enter vicedean date of birth")
    public void enter_vice_dean_date_of_birth() {

        vicedeanbirth_day = "25-05-1988";
        commonLocator.dateOfBirth.sendKeys(vicedeanbirth_day);

        WaitUtils.waitFor(2);
    }


    @Given("click Vice Dean Management Link")
    public void click_vice_dean_management_Link() {
        JSUtils.clickWithTimeoutByJS(createViceDeanPage.ViceDeanManagementLink);
    }


    @Given("verify Vice Dean created successfully confirmation message")
    public void verify_vice_dean_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 15);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Vice dean Saved"));
    }

    //DB

    @Given("connect to vicedean database")
    public void connect_to_dean_database() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
    }


    @Given("get vicedean Data by username")
    public void get_vice_dean_Data_by_username() throws SQLException {
        String query = "select * from vice_dean where username = '" + fakerUsername + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();

    }

    @Then("validate vicedean created on db")
    public void validate_vice_dean_created_on_db() throws SQLException, ParseException {

        String actualUsername = resultSet.getString("username");
        String actualSSN = resultSet.getString("ssn");
        String actualBirth_day = resultSet.getString("birth_day");
        String actualBirth_place = resultSet.getString("birth_place");
        String actualGender = resultSet.getString("gender");
        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualPhoneNumber = resultSet.getString("phone_number");
        SimpleDateFormat expectedDateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String formattedExpectedDate = expectedDateFormat.format(expectedDateFormat.parse("25-05-1988"));
        String formattedActualDate= new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(actualBirth_day));

        assertEquals(formattedExpectedDate, formattedActualDate);
        assertEquals(fakerUsername, actualUsername);
        assertEquals(fakeSsn, actualSSN);
        assertEquals(fakerName, actualName);
        assertEquals(fakerSurname, actualSurname);
        //assertEquals(formattedDate, actualBirth_day);
        assertEquals(fakerBirthPlace, actualBirth_place);
        assertEquals(fakerFormattedPhoneNumber, actualPhoneNumber);
        assertEquals("1", actualGender);


    }

    //API

    @Given("send get All vice dean request on API")
    public void send_get_All_vice_dean_request_on_API() {
        spec.pathParams("first", "vicedean", "second", "getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }


    @Then("validate that vicedean created")
    public void validate_that_vice_dean_created() throws ParseException {

//        JsonPath jsonPath = response.jsonPath();
//        List<String> vicedeanData = jsonPath.getList("findAll{it.username=='viceDeanKama'}");
//        String actUsername = jsonPath.getList("findAll{it.username=='viceDeanKama'}.username").get(0).toString();
//        System.out.println("deanData = " + vicedeanData);
//        assertEquals("viceDeanKama", actUsername);

        JsonPath jsonPath = response.jsonPath();
        List<String> vicedeanData = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}");
        System.out.println("vicedeanData = " + vicedeanData);
        String actUsername = jsonPath.getList("findAll{it.username=='" + fakerUsername + "'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.gender").get(0).toString();
        String actSsn = jsonPath.getList("findAll{it.username=='"+fakerUsername+"'}.ssn").get(0).toString();
        SimpleDateFormat expectedDateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String formattedExpectedDate = expectedDateFormat.format(expectedDateFormat.parse("25-05-1988"));
        String formattedActualDate= new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(actBirthDay));


        assertEquals(200, response.statusCode());
        assertEquals(formattedExpectedDate, formattedActualDate);
        assertEquals(fakerUsername, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakerName, actName);
        assertEquals(fakerSurname, actSurname);
       // assertEquals(formattedDate, actBirthDay);
        assertEquals(fakerBirthPlace, actBirthPlace);
        assertEquals(fakerFormattedPhoneNumber, actPhoneNumber);
        assertEquals("FEMALE", actGender);

    }
}
