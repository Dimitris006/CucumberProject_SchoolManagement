package stepdefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.CommonLocator;
import pages.ContactPage;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utilities.WaitUtils.waitFor;

public class Api_US02 {
    RegisterPage registerPage = new RegisterPage();
    CommonLocator commonLocator = new CommonLocator();
    Faker faker = new Faker();
    Connection connection;
    ResultSet resultSet;
    public static String actidNumber;
    public static int guestUserId;
    Response response;
    ContactPage contactPage = new ContactPage();
    LoginPage loginPage = new LoginPage();



    @Given("user navigate to Url {string}")
    public void user_navigate_to_url(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Given("user click on register link")
    public void user_click_on_register_link() {
        JSUtils.clickWithTimeoutByJS(registerPage.registerLink);

    }
    @Given("user enter name {string}")
    public void user_enter_name(String string) {
        registerPage.nameInput.sendKeys("Sanam");
    }
    @Given("user enter surname {string}")
    public void user_enter_surname(String string) {
        registerPage.surname.sendKeys("Sabah");
    }
    @Given("user enter birthplace {string}")
    public void user_enter_birthplace(String string) {
        registerPage.birthPlace.sendKeys("Kalamata");
    }
    @Given("enter valid Tel number")
    public void enter_valid_tel_number() {
        registerPage.phoneNumber.sendKeys("334-999-4433");
    }
    @Given("user click on radio button")
    public void user_click_on_radio_button() {
        waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,250);
        actions.perform();
        waitFor(2);
        registerPage.femaleRadioButton.click();
    }
    @Given("user enters date of birth {string}")
    public void user_enters_date_of_birth(String string) {
        waitFor(2);
        registerPage.dateOfBirth.sendKeys("05/04/2014");
    }
    @Given("enters valid SSN")
    public void enters_valid_ssn() {
        registerPage.ssn.sendKeys("444-55-8888");
    }
    @Given("user enter user name {string}")
    public void user_enter_user_name(String string) {
        waitFor(2);
        registerPage.userName.sendKeys("sanamsabah");
    }
    @Given("enters password {string}")
    public void enters_password(String string) {
        registerPage.passwordInput.sendKeys("Sanam1234@");
        WaitUtils.waitFor(3);
    }
    @Given("user click on register button")
    public void user_click_on_register_button() {
//        registerPage.registerButton.click();
        JSUtils.clickWithJS(registerPage.registerButton);


        Driver.closeDriver();
    }
//    @Then("verify GuestUser registered alert is seen")
//    public void verify_guest_user_registered_alert_is_seen() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }




    @Given("user navigates to the Web {string}")
    public void user_navigates_to_the_web(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Given("user clicks on the signin link")
    public void user_clicks_on_the_signin_link() {
        loginPage.loginLink.click();
        WaitUtils.waitFor(3);
    }
    @Given("user send the username")
    public void user_send_the_username() {
        loginPage.userName.sendKeys("AdminProjectDot");
    }
    @Given("user send the password")
    public void user_send_the_password() {
        loginPage.password.sendKeys("Project11+");
    }
    @Given("user click on singin button")
    public void user_click_on_singin_button() {
        loginPage.loginButton.click();
    }
    @Given("user click on the menu button")
    public void user_click_on_the_menu_button() {
        commonLocator.menuButton.click();
    }
    @Given("user click on the guest user")
    public void user_click_on_the_guest_user() {
        commonLocator.guestUser.click();
        WaitUtils.waitFor(3);
    }
    @Then("user verify to see the guest user")
    public void user_verify_to_see_the_guest_user() {
        assertTrue(commonLocator.guestUserList.getText().contains("Guest User List"));
    }

    //@Given("send get request to get all guest users")
    //public void send_get_request_to_get_all_guest_users() {
    //    spec.pathParams("first", "guestUser",
    //            "second", "getAll").queryParam("size", "10000");
    //    response = given(spec).get("{first}/{second}");
    //    response.prettyPrint();
    //}
    @Then("validate  username {string} name {string} phone_number {string}  ssn {string}  by API")
    public void validate_username_name_phone_number_ssn_by_api(String username, String ssn, String name, String phoneNumber) {


        JsonPath jsonPath = response.jsonPath();
        actidNumber = jsonPath.getList("content.findAll{it.username=='sanamsabah'}.id").get(0).toString();
        guestUserId = Integer.parseInt(actidNumber);
        String actUsername = jsonPath.getList("content.findAll{it.username=='sanamsabah'}.username").get(0).toString();
        String actSsn = jsonPath.getList("content.findAll{it.username=='sanamsabah'}.ssn").get(0).toString();
        String actName = jsonPath.getList("content.findAll{it.username=='sanamsabah'}.name").get(0).toString();
        String actPhoneNumber= jsonPath.getList("content.findAll{it.username=='sanamsabah'}.phoneNumber").get(0).toString();

        assertEquals(200, response.statusCode());
        assertEquals("sanamsabah", actUsername);
        assertEquals("444-55-8888", actSsn);
        assertEquals("Sanam", actName);
        assertEquals("334-999-4433", actPhoneNumber);

    }

    @Then("validate user {string} is deleted")
    public void validate_user_is_deleted(String string) {
        spec.pathParams("first", "guestUser", "second", "delete", "third", guestUserId);
        response = given(spec).delete("{first}/{second}/{third}");

//        assertEquals(200, response.statusCode());
//        assertTrue(response.asString().contains("guestUser"));
    }
}
