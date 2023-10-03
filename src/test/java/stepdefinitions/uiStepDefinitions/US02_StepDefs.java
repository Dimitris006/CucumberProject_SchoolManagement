package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import pages.*;
import pages.ContactPage;


//import pages.Homepage;
import pages.Homepage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.WaitUtils;

public class US02_StepDefs {

    //Homepage homepage = new Homepage();

    ContactPage homepage = new ContactPage();
    LoginPage loginPage = new LoginPage();
    StudentChooseLessonPage studentChooseLessonPage = new StudentChooseLessonPage();
    CommonLocator commonLocator = new CommonLocator();
    Faker faker = new Faker();


    @Given("user goes to url")
    public void user_goes_to_url() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("User clicks on the login link")
    public void user_clicks_on_the_login_link() {
        loginPage.loginLink.click();
        WaitUtils.waitFor(3);
    }
    @When("User sends the user name")
    public void user_sends_the_user_name() {
      loginPage.userName.sendKeys("HamidBatch159");

    }
    @When("User sends the password")
    public void user_sends_the_password() {
     loginPage.password.sendKeys("78638692650_abC");
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
      loginPage.loginButton.click();
    }
    @Then("Verify if the user logged in")
    public void verify_if_the_user_logged_in() {
        //it is all happening too fast!
        // give wait here so there is some time to see and assert + to click menu button after
        WaitUtils.waitFor(2);
        Assert.assertTrue(loginPage.verifyUserLogin.isDisplayed());
    }


    @When("Click on the Menu Button")
    public void click_on_the_menu_button() {
        WaitUtils.waitFor(1);
        commonLocator.menuButton.click();
    }
    @When("Open the Main menu")
    public void open_the_main_menu() {


    }
    @When("Click on the Guest User")
    public void click_on_the_guest_user() {
        commonLocator.guestUser.click();
        WaitUtils.waitFor(3);

    }
    @When("Open the Guest user List")
    public void open_the_guest_user_list() {
      Assert.assertTrue(commonLocator.guestUserList.isDisplayed());
      WaitUtils.waitFor(3);

    }
    @When("Click on Delet button")
    public void click_on_delet_button() {
        commonLocator.deleteUserGuest.click();
        WaitUtils.waitFor(3);

    }
    @Then("Verify if the user is deleted")
    public void verify_if_the_user_is_deleted() {
       Assert.assertTrue(commonLocator.getDeleteUserGuestSuccessfully.isDisplayed());
       WaitUtils.waitFor(3);
       Driver.closeDriver();

    }
}