package stepdefinitions.dbStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_US18 {

    Connection connection;

    String student_1 = "2986";
    String student_2 = "2983";
    String student_3 = "1738";
    @Given("teacher is able to view all student information on database")
    public void teacher_is_able_to_view_all_student_information_on_database() throws SQLException {

        connection = DBUtils.connectToDatabase();
        System.out.println("Connected to: " + connection.getCatalog() );


        //create statement object
        Statement statement = connection.createStatement();

        //select all student info
        ResultSet allStudent = statement.executeQuery(
          "SELECT * FROM public.student_info " +
              "ORDER BY id;"
        );

        //print names to console

        System.out.println(
                "==================================\n" +
                        "ALL STUDENTS\n" +
                "=================================="
        );

        while (allStudent.next() ) {
            StringBuilder studentInfo = new StringBuilder();
            studentInfo.append("{");
            studentInfo.append("\n  id: ").append(allStudent.getInt("id") );
            studentInfo.append("\n  absentee: ").append(allStudent.getInt("absentee") );
            studentInfo.append("\n  exam_average: ").append(allStudent.getDouble("exam_average") );
            studentInfo.append("\n  final_exam: ").append(allStudent.getDouble("final_exam") );
            studentInfo.append("\n  info_note: ").append(allStudent.getString("info_note") );
            studentInfo.append("\n  letter_grade: ").append(allStudent.getString("letter_grade") );
            studentInfo.append("\n  midterm_exam: ").append(allStudent.getDouble("midterm_exam") );
            studentInfo.append("\n  education_term_id: ").append(allStudent.getInt("education_term_id") );
            studentInfo.append("\n  student_id: ").append(allStudent.getInt("student_id") );
            studentInfo.append("\n}");

            System.out.println(studentInfo);
        }

        statement.close();
        allStudent.close();
    }

    @And("teacher can search students by id")
    public void teacherCanSearchStudentsById() throws SQLException {

        //create a new statement object
        Statement statement = connection.createStatement();

        //select students by their id
        ResultSet studentsById = statement.executeQuery(
                "SELECT * FROM public.student_info " +
                    "WHERE public.student_info.\"id\" " +
                    "IN ("+ student_1 +","+ student_2 +","+ student_3 +") " +
                    "ORDER BY id;"
        );

        System.out.println(
                "==================================\n" +
                        "STUDENTS BY THEIR IDs\n" +
                "=================================="
        );

        while (studentsById.next() ) {
            StringBuilder studentInfo = new StringBuilder();
            studentInfo.append("{");
            studentInfo.append("\n  id: ").append(studentsById.getInt("id") );
            studentInfo.append("\n  absentee: ").append(studentsById.getInt("absentee") );
            studentInfo.append("\n  exam_average: ").append(studentsById.getDouble("exam_average") );
            studentInfo.append("\n  final_exam: ").append(studentsById.getDouble("final_exam") );
            studentInfo.append("\n  info_note: ").append(studentsById.getString("info_note") );
            studentInfo.append("\n  letter_grade: ").append(studentsById.getString("letter_grade") );
            studentInfo.append("\n  midterm_exam: ").append(studentsById.getDouble("midterm_exam") );
            studentInfo.append("\n  education_term_id: ").append(studentsById.getInt("education_term_id") );
            studentInfo.append("\n  student_id: ").append(studentsById.getInt("student_id") );
            studentInfo.append("\n}");

            System.out.println(studentInfo);
        }

        statement.close();
        studentsById.close();
        connection.close();
    }
}
