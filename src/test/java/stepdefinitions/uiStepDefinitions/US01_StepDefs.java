package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.CommonLocator;
import pages.RegisterPage;
import utilities.*;
import utilities.Driver;

import java.io.IOException;
import java.sql.*;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakeSsn;
import static stepdefinitions.uiStepDefinitions.US13_StepDefs.fakeUsername;
import static utilities.WaitUtils.waitFor;

public class US01_StepDefs {

    private static String guestUserSurname;
    private static String guestUserUsername;
    RegisterPage registerPage = new RegisterPage();
    CommonLocator commonLocator = new CommonLocator();
    Faker faker = new Faker();
    Connection connection;
    ResultSet resultSet;
    Response response;


    @And("user clicks on register link")
    public void userClicksOnRegisterLink() {
        JSUtils.clickWithTimeoutByJS(registerPage.registerLink);
    }


    @And("user enters surname {string}")
    public void userEntersSurname(String arg0) {
        guestUserSurname = faker.name().firstName();
        waitFor(2);
        registerPage.surname.sendKeys(guestUserSurname);
    }

    @And("user enters birthplace {string}")
    public void userEntersBirthplace(String arg0) {
        waitFor(2);
        registerPage.birthPlace.sendKeys(arg0);
    }

    @And("user enters phone number {string}")
    public void userEntersPhoneNumber(String arg0) {
        waitFor(2);
        registerPage.phoneNumber.sendKeys(arg0);
    }

    @And("user clicks on radio button")
    public void userClicksOnRadioButton() {
       waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        actions.perform();
        waitFor(2);
       registerPage.femaleRadioButton.click();
    }

    @And("user enter date of birth {string}")
    public void userEnterDateOfBirth(String arg0) {
        waitFor(2);
        registerPage.dateOfBirth.sendKeys(arg0);
    }

//    @And("user enters ssn {string}")
//    public void userEntersSsn(String arg0) {
//        waitFor(2);
//        Actions actions = new Actions(Driver.getDriver());
//        actions.scrollByAmount(0,250);
//        actions.perform();
//        waitFor(2);
//        registerPage.ssn.sendKeys(arg0);
//    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        actions.perform();
        registerPage.registerButton.click();
    }

    @Then("verify Guest User registered alert is seen")
    public void verifyGuestUserRegisteredAlertIsSeen() throws IOException {
        waitFor(1);
        BrowserUtils.verifyExpectedAndActualTextMatch("Guest User registered.",registerPage.userRegisteredText);
       //BrowserUtils.verifyElementDisplayed(commonLocator.confirmationMessage);
        //MediaUtils.takeScreenshotOfThisElement(commonLocator.confirmationMessage);

    }

    @And("user enters user name {string}")
    public void userEntersUserName(String arg0) {
        guestUserUsername = faker.name().firstName();
        waitFor(2);
        registerPage.userName.sendKeys(guestUserUsername);
    }

    @Then("verify blank field required message")
    public void verifyBlankFieldRequiredMessage() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Required",registerPage.requiredMessage);
    }


    @And("enter invalid phone number")
    public void enterInvalidPhoneNumber() {
        registerPage.phoneNumber.sendKeys("------------");
    }

    @Then("verify Invalid phone number alert is seen")
    public void verifyInvalidPhoneNumberAlertIsSeen() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Please enter valid phone number",registerPage.invalidPhoneNumberMessage);
    }

    @And("enter invalid ssn number")
    public void enterInvalidSsnNumber() {
        registerPage.ssn.sendKeys("-----------");
    }

    @Then("verify Invalid SSN number alert is seen")
    public void verifyInvalidSSNNumberAlertIsSeen() {
        BrowserUtils.verifyExpectedAndActualTextMatch("Please enter valid SSN number",registerPage.invalidSSNNumberMessage);
    }

    @Then("verify invalid password message seen")
    public void verifyInvalidPasswordMessageSeen() {
        BrowserUtils.verifyExpectedAndActualTextMatch("At least 8 characters",registerPage.invalidPassword);
    }

//    @Given("register connect to database")
//    public void registerconnectToDatabase() throws SQLException {
//       connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
//    }

    @When("get guest user via username {string}")
    public void getGuestUserViaUsername(String username) throws SQLException {


        String query = "select * from guest_user where username = 'Raven'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();

    }

    @Then("validate  username {string} date_of_birth {string}   birth_place {string}   name {string} phone_number {string}  ssn_number {string} surname {string}")
    public void validateUsernameDate_of_birthBirth_placeNamePhone_numberSsn_numberSurname(String username, String birth_day, String birth_place, String name, String phone_number, String ssn, String surname) throws SQLException {
        String actualUsername = resultSet.getString("username");
        String actualBirth_day = resultSet.getString("birth_day");
        String actualBirth_place = resultSet.getString("birth_place");
        String actualName = resultSet.getString("name");
        String actualPhone_number = resultSet.getString("phone_number");
        String actualSsn = resultSet.getString("ssn");
        String actualSurname = resultSet.getString("surname");

        assertEquals(username, actualUsername);
        assertEquals(birth_day, actualBirth_day);
        assertEquals(birth_place, actualBirth_place);
        assertEquals(name, actualName);
        assertEquals(phone_number, actualPhone_number);
        assertEquals(ssn, actualSsn);
        assertEquals(surname, actualSurname);
    }

//    @And("close the connection")
//    public void closeTheConnection() throws SQLException {
//        resultSet.close();
//        connection.close();



    @Given("send get request to get all guest users")
    public void sendGetRequestToGetAllGuestUsers() {

        spec.pathParams("first","guestUser","second","getAll").queryParams("size","10000");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();


    }

    @Then("validate  username {string} date_of_birth {string}   birth_place {string}   name {string} phone_number {string}  ssn_number {string} surname {string} by API")
    public void validateUsernameDate_of_birthBirth_placeNamePhone_numberSsn_numberSurnameByAPI(String username, String birthDay, String birthPlace, String name, String phoneNumber, String ssn, String surname) {

        JsonPath jsonPath = response.jsonPath();
        String actUsername = jsonPath.getList("content.findAll{it.username=='" + username + "'}.username").get(0).toString();
        String actSsn = jsonPath.getList("content.findAll{it.username=='" + username + "'}.ssn").get(0).toString();
        String actName = jsonPath.getList("content.findAll{it.username=='" + username + "'}.name").get(0).toString();
        String actSurname = jsonPath.getList("content.findAll{it.username=='" + username + "'}.surname").get(0).toString();
        String actBirthDay= jsonPath.getList("content.findAll{it.username=='" + username + "'}.birthDay").get(0).toString();
        String actBirthPlace= jsonPath.getList("content.findAll{it.username=='" + username + "'}.birthPlace").get(0).toString();
        String actPhoneNumber= jsonPath.getList("content.findAll{it.username=='" + username + "'}.phoneNumber").get(0).toString();



        assertEquals(200, response.statusCode());
        assertEquals(username, actUsername);
        assertEquals(ssn, actSsn);
        assertEquals(name, actName);
        assertEquals(surname, actSurname);
        assertEquals(birthDay, actBirthDay);
        assertEquals(birthPlace, actBirthPlace);
        assertEquals(phoneNumber, actPhoneNumber);


//    }


    }
}
