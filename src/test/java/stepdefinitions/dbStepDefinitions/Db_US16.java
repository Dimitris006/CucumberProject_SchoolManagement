package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;
import utilities.JDBCUtils;
import java.sql.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.fakerName;

public class Db_US16 {
    //Connection connection;
   // Statement statement;
    ResultSet resultSet;
    @Given("connect to DB")
    public void connectToDB() throws SQLException {
       // connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");// connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "AdminJohn", "John.123");
       //  statement = connection.createStatement();
    }
    @When("get message")
    public void getMessage() throws SQLException {

       String query = "SELECT  * FROM contact_message WHERE name='Irina'";
       //String query = "SELECT  * FROM contact_message WHERE name= '" + fakerName + "'";
        resultSet = JDBCUtils.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString("message"));
    }
    @Then("validate body contains date {string}, email {string}, message {string}, name {string}, subject {string}")
    public void validateBodyContainsDateEmailMessageNameSubject(String date, String email, String message, String name, String subject) throws SQLException {
        String actualDate = resultSet.getString("date");
        String actualEmail = resultSet.getString("email");
        String actualMessage = resultSet.getString("message");
        String actualName = resultSet.getString("name");
        String actualSubject = resultSet.getString("subject");
        System.out.println(actualEmail);
        System.out.println(actualDate);
        System.out.println(actualMessage);
        System.out.println(actualName);
        System.out.println(actualSubject);
        System.out.println(date);

        assertEquals(date, actualDate);
        assertEquals(email, actualEmail);
        assertEquals(message, actualMessage);
        assertEquals(name, actualName);
        assertEquals(subject, actualSubject);
    }
    @When("get message via non-existing name {string}")
    public void getMessageViaNonExistingName(String name) throws SQLException {
        String query = "select from contact_message where name='XXXIrina'";
        // String sqlQuery = "select  * from  contact_message where name= '" + fakerName + "'";
        resultSet = DBUtils.executeQuery(query);
    }
    @Then("validate  if the message is deleted")
    public void validateIfTheMessageIsDeleted() throws SQLException {
        assertFalse(resultSet.next()); //Since the resultSet is empty, next() method must return false
    }
        @And("close the connection for US16")
        public void closeTheConnection() {
//        resultSet.close();
//        connection.close();
       DBUtils.closeConnection();
    }
}


