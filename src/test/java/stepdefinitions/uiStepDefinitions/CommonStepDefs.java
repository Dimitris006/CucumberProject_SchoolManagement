package stepdefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonLocator;
import pages.LoginPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class CommonStepDefs {

    LoginPage loginPage = new LoginPage();
    CommonLocator commonLocator = new CommonLocator();
    Faker faker = new Faker();

    public static String fakerName;
    public static String fakerSurname;
    public static String fakerBirthPlace;
    public static String dateOfBirth;
    public static String fakerDateOfBirth;

    public static String reverseDateOfBirth;
    public static String fakerPassword;
    public static String fakeSsn;
    public static String fakerFormattedPhoneNumber;
    public static String fakerUsername;
    public static String formattedDate;

    @Then("close the application")
    public void close_the_application() throws InterruptedException {

        Thread.sleep(1000);
        Driver.closeDriver();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        Driver.getDriver().get(url);
        WaitUtils.waitFor(2);
        Driver.getDriver().get(url);
    }

    @Given("user clicks on login link")
    public void user_clicks_on_login_link() {
        loginPage.loginLink.click();
    }

    @Given("user enters username {string}")
    public void user_enters_username(String string) {
        WaitUtils.waitFor(2);
        loginPage.userName.sendKeys(string);
    }

    @Given("user enters password {string}")
    public void user_enters_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @Given("user clicks on login button")
    public void user_clicks_on_login_button() {
        JSUtils.clickWithTimeoutByJS(loginPage.loginButton);
    }


    @Then("enter date of birth")
    public void enter_date_of_birth() {
        dateOfBirth = "01-05-1990";
        reverseDateOfBirth = "1990-05-01";
        commonLocator.dateOfBirth.sendKeys(dateOfBirth);
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
       fakerDateOfBirth = "1990-05-01";
       //commonLocator.dateOfBirth.sendKeys(fakerDateOfBirth);

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
//       fakerDateOfBirth = "01/05/1990";
//       commonLocator.dateOfBirth.sendKeys(fakerDateOfBirth);
    }
    @Then("enter valid phone number")
    public void enter_valid_phone_number() {
        // Generate a fake phone number as a string
        String phoneNumber = faker.phoneNumber().phoneNumber();

        // Format the phone number as XXX-XXX-XXXX
        fakerFormattedPhoneNumber = BrowserUtils.formatPhoneNumber(phoneNumber);

        System.out.println("Generated Phone Number: " + phoneNumber);
        System.out.println("Formatted Phone Number: " + fakerFormattedPhoneNumber);

        commonLocator.phoneNumberField.sendKeys(fakerFormattedPhoneNumber);
    }

    @Then("enter valid SSN")
    public void enter_valid_ssn() {
        fakeSsn = faker.idNumber().ssnValid().toString();
        commonLocator.ssnField.sendKeys(fakeSsn);
    }

    @Then("enter username")
    public void enter_username() {
        fakerUsername = faker.name().username();
        commonLocator.usernameField.sendKeys(fakerUsername);
        System.out.println("Faker Username: " + fakerUsername);
        WaitUtils.waitFor(2);
    }

    @Given("click menu button")
    public void click_menu_button() {
        commonLocator.menuButton.click();
    }

    @Given("click logout button")
    public void click_logout_button() {

        commonLocator.logOutButton.click();
        JSUtils.clickWithTimeoutByJS(commonLocator.yesButton);
    }

    @Given("enter Name")
    public void enter_Name() {
        fakerName = faker.name().firstName();
        commonLocator.name.sendKeys(fakerName);
    }

    @Given("enter Surname")
    public void enter_Surname() {
        fakerSurname = faker.name().lastName();
        commonLocator.surname.sendKeys(fakerSurname);
    }

    @Given("enter Birth Place")
    public void enter_Birth_Place() {
        fakerBirthPlace = faker.country().capital();
        commonLocator.birthplace.sendKeys(fakerBirthPlace);
    }

    @Given("select Male Gender")
    public void select_Gender_Male() {
        WaitUtils.waitFor(2);
        JSUtils.clickWithTimeoutByJS(commonLocator.genderMale);
    }

    @Given("select Female Gender")
    public void select_Gender_Female() {
        JSUtils.clickWithTimeoutByJS(commonLocator.genderFemale);
    }

    @Given("enter password")
    public void enter_password() {
        fakerPassword = "Testpw12";
        commonLocator.passwordField.sendKeys(fakerPassword);
    }

    @Given("enter password with only seven chars")
    public void enter_password_with_only_seven_chars() {
        commonLocator.passwordField.sendKeys("Testpw1");
    }

    @Given("enter password without lowercase chars")
    public void enter_password_without_lowercase_chars() {
        commonLocator.passwordField.sendKeys("TESTPW12");
    }

    @Given("enter password without uppercase chars")
    public void enter_password_without_uppercase_chars() {
        commonLocator.passwordField.sendKeys("testpw12");
    }

    @Given("enter password without numbers")
    public void enter_password_without_numbers() {
        commonLocator.passwordField.sendKeys("Testpwtest");
    }

    @Given("click submit button")
    public void click_submit_Button() {
        JSUtils.clickWithTimeoutByJS(commonLocator.submitButton);
        JSUtils.scrollAllTheWayUpJS();
        WaitUtils.waitFor(1);
    }

    @Given("verify Admin created successfully confirmation message")
    public void verify_admin_created_successfully_confirmation_message() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assertTrue(commonLocator.confirmationMessage.getText().contains("Admin Saved"));
    }

    @Given("verify Admin created successfully confirmation message does not appears")
    public void verify_admin_created_successfully_confirmation_message_does_not_appears() {
        WaitUtils.waitForVisibility(commonLocator.confirmationMessage, 5);
        assert(commonLocator.confirmationMessage.getText().contains("Admin Saved"));
    }
    @Then("verify password at least eight characters error message")
    public void verifyPasswordAtLeastEightCharactersErrorMessage() {
        Assert.assertTrue(commonLocator.passwordLessCharErrorMessage.isDisplayed());
    }

    @Then("verify password One uppercase character error message")
    public void verifyPasswordOneUppercaseCharacter() {
        Assert.assertTrue(commonLocator.passwordWithoutUpperCaseErrorMessage.isDisplayed());
    }

    @Then("verify password One lowercase character error message")
    public void verifyPasswordOneLowercaseCharacterErrorMessage() {
        Assert.assertTrue(commonLocator.passwordWithoutLowerCaseErrorMessage.isDisplayed());
    }

    @Then("verify password One number character error message")
    public void verifyPasswordOneNumberCharacterErrorMessage() {
        Assert.assertTrue(commonLocator.passwordWithoutNumberErrorMessage.isDisplayed());
    }

    @Then("click last page button")
    public void click_last_page_button(){

        WaitUtils.waitFor(3);
        JSUtils.clickWithTimeoutByJS(commonLocator.goLastPageButton);
    }

    //use this if you want to do the entire operation of going to site
    //and logging in as Vice Dean
    //If you need to reuse for each scenario, then use this in Background
    @Given("login as vice dean {string} {string}")
    public void loginAsViceDean(String username, String password) {

        //go to url
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Wait for the page to load - throw exception if not load in 15s
        WaitUtils.waitForPageToLoad(15);

        //Find login element and click
        WaitUtils.waitForClickablility(loginPage.loginLink, 15);
        loginPage.loginLink.click();

        //Wait for page load + assert correct page has loaded
        WaitUtils.waitForPageToLoad(15);
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://managementonschools.com/login"
        );

        //Now use credentials for logging in
        //username
        WaitUtils.waitForClickablility(loginPage.userName, 15);
        loginPage.userName.sendKeys(username);

        //password
        WaitUtils.waitForClickablility(loginPage.password, 15);
        loginPage.password.sendKeys(password);

        //login button click
        WaitUtils.waitForClickablility(loginPage.loginButton, 15);
        loginPage.loginButton.click();

        //Wait for next page load correctly + with username
        //page correction
        WaitUtils.waitFor(2);
        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://managementonschools.com/lesson"
        );

        //username correction
        WebElement getUsernameLabel = Driver.getDriver().findElement(By.cssSelector(
                ".navbar span > span:nth-child(2)"
        ));

        WaitUtils.waitForVisibility(getUsernameLabel, 15);
        Assert.assertEquals(
                username,
                getUsernameLabel.getText()
        );

        System.out.println("Complete...");
    }
    @Then("verify submit fails")
    public void verify_submit_fails() {

        BrowserUtils.verifyElementNotDisplayed(commonLocator.confirmationMessage);
    }
    @Then("password without numbers error message appears")
    public void passwordWithoutNumbersErrorMessageAppears() {
        BrowserUtils.verifyElementDisplayed(commonLocator.passwordWithoutNumberErrorMessage);
    }

    @Then("password without uppercase error message appears")
    public void passwordWithoutUppercaseErrorMessageAppears() {
        BrowserUtils.verifyElementDisplayed(commonLocator.passwordWithoutUpperCaseErrorMessage);
    }

    @Then("password without lowercase error message appears")
    public void passwordWithoutLowercaseErrorMessageAppears() {
        BrowserUtils.verifyElementDisplayed(commonLocator.passwordWithoutLowerCaseErrorMessage);
    }

    @Then("password less then 8 character error message appears")
    public void passwordLessThen8CharacterErrorMessageAppears() {
        BrowserUtils.verifyElementDisplayed(commonLocator.passwordLessCharErrorMessage);
    }
}
