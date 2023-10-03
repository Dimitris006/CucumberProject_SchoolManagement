package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Db_US20 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    // Bu metot tarih dönüşümünü gerçekleştirir
//    private String convertDate(String sourceDateStr) {
//        // Source date format
//        SimpleDateFormat sourceFormat = new SimpleDateFormat("MMM dd, yyyy");
//
//        // Target date format
//        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            // Parse the source date
//            Date sourceDate = sourceFormat.parse(sourceDateStr);
//
//            // Format the target date
//            return targetFormat.format(sourceDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @When("get meeting via description {string}")
    public void getMeetingViaDescription(String description) throws SQLException {
        //Statement statement = connection.createStatement();
        String query = "SELECT * FROM meet where description = 'rehberlk'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();

    }

    @Then("validate  description {string} date {string} start_time {string}   stop_time {string}")
    public void validate_description_date_start_time_stop_time(String description, String date, String start_time, String stop_time) throws SQLException {

        String actualDescription = resultSet.getString("description");
        String actualDate = (resultSet.getString("date")); // Tarih dönüşümünü kullan
        String actualStart_time = resultSet.getString("start_time");
        String actualStop_time = resultSet.getString("stop_time");

        assertEquals(description, actualDescription);
        assertEquals(date, actualDate);
        assertEquals(start_time, actualStart_time);
        assertEquals(stop_time, actualStop_time);
    }

    @When("get updated meeting via description {string}")
    public void getUpdatedMeetingViaDescription(String description) throws SQLException {

        String query = "SELECT * FROM meet where description = 'Toplanti updated'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();
    }

    @Then("validate  updateddescription {string}")
    public void validateUpdateddescription(String description) throws SQLException {
        String actualUpdatedDescription = resultSet.getString("description");
        assertEquals(description, actualUpdatedDescription);

    }

    @When("get deleted meeting via description {string}")
    public void getDeletedMeetingViaDescription(String description) throws SQLException {

        String query = "SELECT * FROM meet where description = 'Delete meeting'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();
    }


    @Then("validate  there is such meeting description  {string}")
    public void validateThereIsSuchMeetingDescription(String description) throws SQLException {
        assertFalse(resultSet.next());
//        String actualDeletedDescription = resultSet.getString("description");
//        assertNull(description, actualDeletedDescription);
    }



//    @Then("validate  description {string} date {string} start_time {string}   stop_time {string}")
//    public void validateDescriptionDateStart_timeStop_time(String description, String date, String start_time, String stop_time) throws SQLException {
//        String actualDescription = resultSet.getString("description");
//        String actualDate = convertDate(resultSet.getString("date")); // Tarih dönüşümünü kullan
//        String actualStart_time = resultSet.getString("start_time");
//        String actualStop_time = resultSet.getString("stop_time");
//
//        assertEquals(description, actualDescription);
//        assertEquals(date, actualDate);
//        assertEquals(start_time, actualStart_time);
//        assertEquals(stop_time, actualStop_time);
//    }
}
