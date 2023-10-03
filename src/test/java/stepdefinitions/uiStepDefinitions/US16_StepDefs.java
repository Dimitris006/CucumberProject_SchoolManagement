package stepdefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DeanContactGetAllPage;
import pages.ViceDean_AdminManagementPage;
import utilities.BrowserUtils;
import utilities.MediaUtils;
import java.io.IOException;
import static utilities.WaitUtils.waitFor;

public class US16_StepDefs {
    ViceDean_AdminManagementPage viceDeanAdminManagementPage= new ViceDean_AdminManagementPage();
    DeanContactGetAllPage deanContactGetAllPage = new DeanContactGetAllPage();

   @And("click Menu button")
   public void clickMenuButton() {
      waitFor(2);
      viceDeanAdminManagementPage.navMenuButton.click();
      waitFor(1);
  }
    @And("click Get All button")
    public void contact_get_all_button() {
        waitFor(2);
        deanContactGetAllPage.contactGetAllButton.click();
        waitFor(2);
   }
   // US16_TC01
    @Then("Verify Delete button is visible")
    public void verify_delete_button_is_visible() {
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   // US16_TC02
    @Then("verify message is visible")
    public void verify_message_is_seen() {
        waitFor(3);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyMessageIsSeen);
    }
    @Then("verify Name is visible")
    public void verify_name_is_visible() {
       BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyNameIsSeen);
        waitFor(3);
    }
    @Then("verify Email is visible")
    public void verify_email_is_visible() {
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyEmailIsSeen);
        waitFor(3);
    }
    @Then("verify Date is visible")
    public void verify_date_is_visible() {
        waitFor(2);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifyDateIsSeen);
    }
    @Then("verify Subject is visible")
    public void verify_subject_is_visible() {
        waitFor(3);
        BrowserUtils.verifyElementDisplayed(deanContactGetAllPage.verifySubjectIsSeen);
    }
   //US16_TC03
    @Then("verify ability to delete messages")
    public void verify_message_is_deleted() {
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
