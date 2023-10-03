package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.sql.*;

import static org.junit.Assert.assertEquals;


public class US21_DBStepDefs {

    ResultSet resultSet;

    @Given("connect to Data Base")
    public void connect_to_Data_Base() {}

    @When("get selected course via student name {string}")
    public void get_selected_course_via_student_name(String name) throws SQLException {
        String query = "SELECT s.name, l.lesson_name, lp.day, lp.start_time, lp.stop_time\n" +
                "FROM student AS s\n" +
                "LEFT JOIN student_lessonprogram AS slp ON s.id = slp.student_id\n" +
                "LEFT JOIN lesson_program AS lp ON slp.lesson_program_id = lp.id\n" +
                "LEFT JOIN lesson AS l ON lp.id = l.lesson_id\n" +
                "WHERE s.id = 1449";
        resultSet = DBUtils.executeQuery(query);
        resultSet.next();//To move the pointer to the records, we need to call next()
        resultSet.next();
        resultSet.next();
    }
    @Then("validate course lesson title {string} day {string} start_time {string} stop_time {string}")
    public void validate_course_lesson_title_day_start_time_stop_time(String lesson_name, String day, String start_time, String stop_time) throws SQLException {

        String actualLessonName = resultSet.getString("lesson_name");
        String actualDay = resultSet.getString("day");
        String actualStartTime = resultSet.getString("start_time");
        String actualStopTime = resultSet.getString("stop_time");

        assertEquals(lesson_name, actualLessonName);
        assertEquals(day, actualDay);
        assertEquals(start_time, actualStartTime);
        assertEquals(stop_time, actualStopTime);
    }
    @Then("close the connection to DB")
    public void close_the_connection_to_DB() {
        DBUtils.closeConnection();
    }
}
