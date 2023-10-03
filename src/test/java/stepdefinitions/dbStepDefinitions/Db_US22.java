package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;



import java.sql.*;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.uiStepDefinitions.CommonStepDefs.*;



public class Db_US22 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;


//    @Given("connect to database")
//    public void  connect_to_database() throws SQLException {
//        //connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
//        //The connection will be created when we call executeQuery() method from JDBCUtils class.
//    }


    @When("get admin user via username")
    public void get_admin_user_via_username() throws SQLException {

        //statement = connection.createStatement();
        String query = "select * from public.admins where username = '" + fakerUsername + "'";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();//To move the pointer to the records, we need to call next()
    }


    @Then("validate username name phone_number ssn surname birth_place date_of_birth password")
    public void validateUsernameNamePhone_numberSsnSurnameBirth_placeDate_of_birthPassword() throws SQLException {

        String actualUsername = resultSet.getString("username");
        String actualBirthPlace = resultSet.getString("birth_place");
        //String actualDateOfBirth = resultSet.getString("date_of_birth");
        //String actualPassword = resultSet.getString("password");
        String actualName = resultSet.getString("name");
        String actualPhone_number = resultSet.getString("phone_number");
        String actualSsn = resultSet.getString("ssn");
        String actualSurname = resultSet.getString("surname");

        assertEquals(fakerUsername, actualUsername);//fakeUsername will be generated on UI part and will be validated here
        assertEquals(fakerBirthPlace, actualBirthPlace);
        //assertEquals(formattedDate, actualDateOfBirth);
        //assertEquals(fakerDateOfBirth, actualDateOfBirth);
        //assertEquals(fakerPassword, actualPassword);
        //assertEquals(formattedDate, actualDateOfBirth);
        //assertEquals(fakerPassword, actualPassword);
        assertEquals(fakerName, actualName);
        assertEquals(fakerFormattedPhoneNumber, actualPhone_number);
        assertEquals(fakeSsn, actualSsn);
        assertEquals(fakerSurname, actualSurname);
    }


//    @Then("close the connection")
//    public void close_the_connection() throws SQLException {
//
//        //resultSet.close();
//        //connection.close();
//        DBUtils.closeConnection();
//
//    }

}

