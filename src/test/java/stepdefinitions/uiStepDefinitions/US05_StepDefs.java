package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AdminManagementPage;
import pages.DeanManagementPage;
import pages.LoginPage;
import utilities.*;

import static base_url.BaseUrl.deanSetUp;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerFormattedPhoneNumber;
import static stepdefinitions.uiStepDefinitions.US13_StepDefs.birth_day;
import static utilities.FakerUtils.faker;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class US05_StepDefs {

    LoginPage loginPage = new LoginPage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();

    DeanManagementPage deanManagementPage = new DeanManagementPage();

    Faker faker = new Faker();
    Response response;

    ResultSet resultSet;
    ResultSet updatedResultSet;

    private String nameDean;
    private static String nameDeanUpdate;

    private static String formattedPhoneNumber;

    private static String formattedUpdatedPhoneNumber;

    private static String fakeSsn;

    private static String fakeUpdatedSsn;

    private static String fakeUsername;

    private static String fakeUpdatedUsername;

    private static  String fakeDeanName;

    private static  String fakeDeanSurname;

    private static String surnameDeanUpdate;






    @Given("Admin user is on The Managementon Schools website")
    public void admin_user_is_on_the_managementon_schools_website() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WaitUtils.waitFor(1);
    }

    @And("clicks on Login link")
    public void clicksOnLoginLink() {
        WaitUtils.waitFor(1);
        JSUtils.clickWithTimeoutByJS(loginPage.loginLink);
    }


    @And("sees the page has Login title")
    public void sees_the_page_has_login_title() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
        WaitUtils.waitFor(1);
    }

    @When("Admin user enters username on Login page {string}")
    public void admin_user_enters_usename_on_login_page(String string) {
        loginPage.userName.sendKeys("AdminProjectDot");

    }

    @And("enters password on Login page {string}")
    public void entersPasswordOnLoginPage(String string) {
        loginPage.password.sendKeys("Project11+");

    }

    @And("Admin user clicks on login button")
    public void admin_user_clicks_on_login_button() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(1);
    }

    @Then("sees the {string} title")
    public void sees_the_title(String string) {
        Assert.assertTrue(adminManagementPage.adminManagementTitle.getText().contains("Admin Management"));
        WaitUtils.waitFor(1);
    }

    @Given("Admin user clicks on menu button")
    public void admin_user_clicks_on_menu_button() {
        adminManagementPage.menuButton.click();
        WaitUtils.waitFor(1);
    }

    @And("sees the menu list on the left hand side")
    public void sees_the_menu_list_on_the_left_hand_side() {
        Assert.assertTrue(adminManagementPage.buttonClose.isDisplayed());
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String string) {
        adminManagementPage.deanManagementLink.click();
        WaitUtils.waitFor(1);
    }

   /* @Then("sees the Deans information")
    public void sees_the_Deans_information() {
        JSUtils.scrollIntoViewJS(deanManagementPage.deanList);
        Assert.assertTrue(deanManagementPage.name.getText().contains("TeamProject") | deanManagementPage.gender.getText().contains("MALE") |
                deanManagementPage.phoneNumber.getText().contains("444-444-4444") | deanManagementPage.ssn.getText().contains("444-44-4444") |
                deanManagementPage.userName.getText().contains("DeanTeam01"));
        WaitUtils.waitFor(1);
    }*/

    @And("goes to Add Dean section")
    public void goes_to_add_dean_section() {
        Assert.assertTrue(deanManagementPage.addDean.getText().contains("Add Dean"));
        WaitUtils.waitFor(1);
    }

    @And("enters name {string} on Add Dean section")
    public void enters_name_on_add_dean_section(String string) {
        fakeDeanName = faker.name().firstName();
        deanManagementPage.deanName.sendKeys(fakeDeanName);
        WaitUtils.waitFor(1);

    }

    @And("enters surname {string} on Add Dean section")
    public void enters_surname_on_add_dean_section(String string) {

        fakeDeanSurname = faker.name().lastName();
        deanManagementPage.deanSurname.sendKeys(fakeDeanSurname);
    }

    @And("enters birthplace {string} on Add Dean section")
    public void enters_birthplace_on_add_dean_cection(String string) {
        deanManagementPage.deanBirthPlace.sendKeys("Istanbul");
        WaitUtils.waitFor(1);
    }

    @And("clicks on Female for gender on Add Dean section")
    public void clicks_on_female_for_gender_on_add_dean_section() {
        deanManagementPage.deanGender.click();
    }

    @And("enters Date of Birth on Add Dean section")
    public void entersDateOfBirthonAddDeanSection() {
        deanManagementPage.deanBirthDay.sendKeys("11/11/1234");
        WaitUtils.waitFor(1);
    }

    @And("enters Phone number {string} on Add Dean section")
    public void enters_phone_number_on_Add_Dean_Section(String string) {


        String phoneNumber = faker.phoneNumber().phoneNumber();

       formattedPhoneNumber = BrowserUtils.formatPhoneNumber(phoneNumber);

        deanManagementPage.deanPhoneNumber.sendKeys(formattedPhoneNumber);

    }

    @And("enters ssn number {string} on Add Dean section")
    public void enters_ssn_number_on_add_dean_section(String string) {
        fakeSsn = faker.idNumber().ssnValid();
        deanManagementPage.deanSsnNumber.sendKeys(fakeSsn);
        WaitUtils.waitFor(1);
    }

    @And("Admin user enters a new username {string} on Add Dean section")
    public void adminUserEntersANewUsernameOnAddDeanSection(String string) {
        fakeUsername = faker.bothify("????##");
        deanManagementPage.deanUsername.sendKeys(fakeUsername);

    }

    @And("enters the password {string} on Add Dean section")
    public void entersThePasswordOnAddDeanSection(String string) {
        deanManagementPage.deanPassword.sendKeys("Istanbul1");
        WaitUtils.waitFor(1);
    }

    @And("user clicks on submit on Add Dean section")
    public void userClicksOnSubmitOnAddDeanSection() {
        deanManagementPage.addDeanSubmit.click();
    }

    @Then("sees the Dean Saved alert")
    public void seesTheDeanSavedalert() throws IOException {
        WaitUtils.waitFor(1);
        BrowserUtils.verifyExpectedAndActualTextMatch("Dean Saved", deanManagementPage.deanSavedText);
        WaitUtils.waitFor(1);

    }

    @And("Admin user goes to the last page of the dean list")
    public void adminUserGoesToTheLastPageOfTheDeanList() {
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastPageButton);
    }

    @And("goes to the last Dean created")
    public void goesToTheLastDeanCreated() {
        String nameOfCreatedDean = deanManagementPage.deanName.getText();
        JSUtils.scrollIntoViewJS(deanManagementPage.lastRowDeanList);
        String lastRow = deanManagementPage.lastRowDeanList.getText();
        System.out.println("lastRow = " + lastRow);
        Assert.assertTrue(lastRow.contains(nameOfCreatedDean));
        WaitUtils.waitFor(1);
    }

    @And("clicks on Edit button on the Dean List")
    public void clicksOnEditButtonOntheDeanList() {
        JSUtils.clickWithTimeoutByJS(deanManagementPage.lastColumnDeanList);
        WaitUtils.waitFor(1);
    }

    @And("enters a new name {string} on edit Dean section")
    public void enters_a_new_name_on_edit_dean_section(String string) {

        nameDeanUpdate = faker.name().firstName();
        ActionUtils.tripleClick(deanManagementPage.updateDeanName);
        deanManagementPage.updateDeanName.sendKeys(nameDeanUpdate);
        WaitUtils.waitFor(1);
    }
    @And("enters surname {string} on edit Dean section")
    public void enters_surname_on_edit_dean_section(String string) {
        surnameDeanUpdate = faker.name().lastName();
        ActionUtils.tripleClick(deanManagementPage.updateDeanSurname);
        deanManagementPage.updateDeanSurname.sendKeys(surnameDeanUpdate);
    }
    @And("enters birthplace {string} on edit Dean section")
    public void enters_birthplace_on_edit_dean_section(String string) {
        ActionUtils.tripleClick(deanManagementPage.updateBirthPlace);
        deanManagementPage.updateBirthPlace.sendKeys("Izmir");
    }
    @Then("clicks on Male for gender on edit Dean section")
    public void clicks_on_male_for_gender_on_edit_dean_section() {
        deanManagementPage.updateDeanGender.click();
        WaitUtils.waitFor(1);
    }
    @Then("enters Date of Birth on edit Dean section")
    public void enters_date_of_birth_on_edit_dean_section() {
       deanManagementPage.updateDeanbirthday.sendKeys("01/01/1001");
    }
    @Then("enters Phone number {string} on edit Dean section")
    public void enters_phone_number_on_edit_dean_section(String string) {

        String updatedPhoneNumber = faker.phoneNumber().phoneNumber();
        formattedUpdatedPhoneNumber = BrowserUtils.formatPhoneNumber(updatedPhoneNumber);
        ActionUtils.tripleClick(deanManagementPage.updateDeanPhoneNumber);
        deanManagementPage.updateDeanPhoneNumber.sendKeys(formattedUpdatedPhoneNumber);
        WaitUtils.waitFor(1);
    }
    @Then("enters ssn number {string} on edit Dean section")
    public void enters_ssn_number_on_edit_dean_section(String string) {
        fakeUpdatedSsn = faker.idNumber().ssnValid();
        ActionUtils.tripleClick(deanManagementPage.updateDeanSsn);
        deanManagementPage.updateDeanSsn.sendKeys(fakeUpdatedSsn);
    }
    @Then("Admin user enters a new username {string} on edit Dean section")
    public void admin_user_enters_a_new_username_on_edit_dean_section(String string) {
        fakeUpdatedUsername = faker.bothify("????##");
        ActionUtils.tripleClick(deanManagementPage.updateDeanUsername);
        deanManagementPage.updateDeanUsername.sendKeys(fakeUpdatedUsername);
        WaitUtils.waitFor(1);
    }


    @And("enters the password on the edit box {string}")
    public void entersThePasswordOnTheEditBox(String string) {
        deanManagementPage.deanPasswordEditBox.sendKeys("Istanbul1");
    }

    @And("Admin user clicks Submit button on the edit box")
    public void adminUserClicksSubmitButtonOnTheEditBox() {
        deanManagementPage.submitButtonEditBox.click();
    }


    @Then("sees the Dean updated Successful alert")
    public void seesTheDeanUpdatedSuccessfulAlert() throws IOException {
        WaitUtils.waitFor(1);
        BrowserUtils.verifyExpectedAndActualTextMatch("Dean updated Successful", deanManagementPage.deanUpdatedSuccessfulText);
        WaitUtils.waitFor(1);
    }

    @Then("sees the the Deans information")
    public void seesTheTheDeansInformation() {
        WaitUtils.waitFor(1);
        String nameOfCreatedDean = deanManagementPage.deanName.getText();
        JSUtils.scrollIntoViewJS(deanManagementPage.lastRowDeanList);
        String lastRow = deanManagementPage.lastRowDeanList.getText();
        System.out.println("lastRow = " + lastRow);
        Assert.assertTrue(lastRow.contains(nameOfCreatedDean));
        WaitUtils.waitFor(1);

    }

    @When("get Dean via username {string}")
    public void get_dean_via_username(String username) throws SQLException {

        String query = "select * from dean where username = '" + fakeUsername + "'";
        System.out.println("fakeUsername = " + fakeUsername);

        resultSet = DBUtils.executeQuery(query);
        resultSet.next();//To move the pointer to the records, we need to call next()

    }

    @Then("validate  name {string}, surname {string}, birth_place {string}, gender {string}, birth_day {string}, phone_number {string},ssn {string}, username{string}")
    public void validate_name_surname_birth_place_gender_birth_day_phone_number_ssn_username(String name, String surname, String birth_place, String gender, String birth_day, String phone_number, String ssn, String username) throws SQLException {
    String actualName = resultSet.getString("name");
    String actualSurname = resultSet.getString("surname");
    String actualBirth_place = resultSet.getString("birth_place");
    String actualGender = resultSet.getString("gender");
    String actualBirth_day = resultSet.getString("birth_day");
    String actualPhone_number = resultSet.getString("phone_number");
    String actualSsn = resultSet.getString("ssn");
    String actualUsername = resultSet.getString("username");
        System.out.println("actualUsername = " + actualUsername);

        assertEquals(fakeDeanName, actualName);
    assertEquals(fakeDeanSurname,actualSurname);
    assertEquals("Istanbul", actualBirth_place);
    assertEquals("1", actualGender);
    assertEquals("1234-11-11", actualBirth_day);
    assertEquals(formattedPhoneNumber, actualPhone_number);
    assertEquals(fakeSsn, actualSsn);
    assertEquals(fakeUsername, actualUsername);

    }
    @When("get updated Dean via username")
    public void getUpdatedDeanViaUsername() throws SQLException {

        //statement = connection.createStatement();
        String query1 = "select * from dean where username = '" + fakeUpdatedUsername + "'";
        System.out.println("fakeUpdatedUsername = " + fakeUpdatedUsername);

        resultSet = DBUtils.executeQuery(query1);
        resultSet.next();//To move the pointer to the records, we need to call next()

    }

    @Then("validate Dean's details are updated")
    public void validateDeanSDetailsAreUpdated() throws SQLException {
        String actualUpdatedName = resultSet.getString("name");
        String actualUpdatedSurname = resultSet.getString("surname");
        String actualUpdatedBirth_place = resultSet.getString("birth_place");
        String actualUpdatedGender = resultSet.getString("gender");
        String actualUpdatedBirth_day = resultSet.getString("birth_day");
        String actualUpdatedPhone_number = resultSet.getString("phone_number");
        String actualUpdatedSsn = resultSet.getString("ssn");
        String actualUpdatedUsername = resultSet.getString("username");
        System.out.println("actualUpdatedUsername = " + actualUpdatedUsername);

        assertFalse(nameDeanUpdate, equals(actualUpdatedName));//fakeUsername will be generated on UI part and will be validated here
        assertFalse(surnameDeanUpdate,equals(actualUpdatedSurname));
        assertFalse("Istanbul", equals(actualUpdatedBirth_place));
        assertFalse("1", equals(actualUpdatedGender));
        assertFalse("11/11/1234", equals(actualUpdatedBirth_day));
        assertFalse(formattedUpdatedPhoneNumber, equals(actualUpdatedPhone_number));
        assertFalse(fakeUpdatedSsn, equals(actualUpdatedSsn));
        assertFalse(fakeUpdatedUsername, equals(actualUpdatedUsername));

    }

    @Given("send get request to get all dean users")
    public void send_get_request_to_get_all_dean_users() {
        https://managementonschools.com/app/dean/getAll
        spec.pathParams("first", "dean", "second", "getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }


    @Then("validate Dean's details are seen")
    public void validate_dean_s_details_are_seen() throws ParseException {

       /* JsonPath jsonPath = response.jsonPath();
        List<String> deanData = jsonPath.getList("findAll{it.username=='ospa16'}");
        String actualUsername = jsonPath.getList("findAll{it.username=='ospa16'}.username").get(0).toString();
        System.out.println("actualUsername = " + actualUsername);*/

        JsonPath jsonPath = response.jsonPath();
        List<String> deanData = jsonPath.getList("findAll{it.username=='" + fakeUsername + "'}");
        System.out.println("deanData = " + deanData);
        String actUsername = jsonPath.getList("findAll{it.username=='" + fakeUsername + "'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='"+ fakeUsername +"'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='"+ fakeUsername +"'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='"+ fakeUsername +"'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='"+fakeUsername+"'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='"+fakeUsername+"'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='"+fakeUsername+"'}.gender").get(0).toString();
        String actSsn = jsonPath.getList("findAll{it.username=='"+fakeUsername+"'}.ssn").get(0).toString();


        assertEquals(200, response.statusCode());
        assertEquals("1234-11-11", actBirthDay);
        assertEquals(fakeUsername, actUsername);
        assertEquals(fakeSsn, actSsn);
        assertEquals(fakeDeanName, actName);
        assertEquals(fakeDeanSurname, actSurname);
        //assertEquals(formattedDate, actBirthDay);
        assertEquals("Istanbul", actBirthPlace);
        assertEquals(formattedPhoneNumber, actPhoneNumber);
        assertEquals("FEMALE", actGender);
    }


    @Given("send get request to get all dean users for API test")
    public void sendGetRequestToGetAllDeanUsersForAPITest() {
        spec.pathParams("first", "dean", "second", "getAll");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("validate Dean's details are updated by API")
    public void validateDeanSDetailsAreUpdatedByAPI() {

        JsonPath jsonPath = response.jsonPath();
        List<String> deanData = jsonPath.getList("findAll{it.username=='" + fakeUpdatedUsername + "'}");
        System.out.println("deanData = " + deanData);
        String actUsername = jsonPath.getList("findAll{it.username=='" + fakeUpdatedUsername + "'}.username").get(0).toString();
        String actName = jsonPath.getList("findAll{it.username=='"+ fakeUpdatedUsername +"'}.name").get(0).toString();
        String actSurname = jsonPath.getList("findAll{it.username=='"+ fakeUpdatedUsername +"'}.surname").get(0).toString();
        String actBirthDay = jsonPath.getList("findAll{it.username=='"+ fakeUpdatedUsername +"'}.birthDay").get(0).toString();
        String actBirthPlace = jsonPath.getList("findAll{it.username=='"+fakeUpdatedUsername+"'}.birthPlace").get(0).toString();
        String actPhoneNumber = jsonPath.getList("findAll{it.username=='"+fakeUpdatedUsername+"'}.phoneNumber").get(0).toString();
        String actGender = jsonPath.getList("findAll{it.username=='"+fakeUpdatedUsername+"'}.gender").get(0).toString();
        String actSsn = jsonPath.getList("findAll{it.username=='"+fakeUpdatedUsername+"'}.ssn").get(0).toString();


        assertEquals(200, response.statusCode());
        assertEquals("1001-01-01", actBirthDay);
        assertEquals(fakeUpdatedUsername, actUsername);
        assertEquals(fakeUpdatedSsn, actSsn);
        assertEquals(nameDeanUpdate, actName);
        assertEquals(surnameDeanUpdate, actSurname);
        assertEquals("Izmir", actBirthPlace);
        assertEquals(formattedUpdatedPhoneNumber, actPhoneNumber);
        assertEquals("MALE", actGender);
    }
}
