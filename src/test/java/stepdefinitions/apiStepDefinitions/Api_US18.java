package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Api_US18 {

    Response response;
    String studentId = "1738";
    String deleteStudentById = "2987";
    StringBuilder studentInfoUpdatePayload;

    @Given("logged in as Dunk teacher, get all student information")
    public void logged_in_as_dunk_teacher_get_all_student_information() {
        response = given(spec)
                .pathParams("studentInfo", "studentInfo", "getAllForTeacher", "getAllForTeacher")
                //Combining multiple queryParam into a single call will NOT work - keep separate
                .queryParam("page", 0)
                .queryParam("size", 32)
                .get("/{studentInfo}/{getAllForTeacher}");
    }
    @Then("assert the information is correct")
    public void assert_the_information_is_correct() {
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        List<String> studentFirstNames = response.jsonPath().getList("content.studentResponse.name");
        List<String> studentLastNames = response.jsonPath().getList("content.studentResponse.name");
        List<String> lessonNames = response.jsonPath().getList("content.lessonName");
        List<Integer> absence = response.jsonPath().getList("content.absentee");
        List<Float> midtermExam = response.jsonPath().getList("content.midtermExam");
        List<Float> finalExam = response.jsonPath().getList("content.finalExam");
        List<String> note = response.jsonPath().getList("content.note");
        List<String> infoNote = response.jsonPath().getList("content.infoNote");
        List<Float> averageInfo = response.jsonPath().getList("content.average");

        //Assert student names
        for (String studentInfo : studentFirstNames) {
            response.then().body("content.studentResponse.name",hasItem(studentInfo));
        }

        //Assert student last names
        for (String studentInfo : studentLastNames) {
            response.then().body("content.studentResponse.name",hasItem(studentInfo));
        }

        //Assert student lesson names
        for (String studentInfo : lessonNames) {
            response.then().body("content.lessonName",hasItem(studentInfo));
        }

        //Assert student absence
        for (int studentInfo : absence) {
            response.then().body("content.absentee",hasItem(studentInfo));
        }

        //Assert student Mid-term exam
        for (float studentInfo : midtermExam) {
            response.then().body("content.midtermExam",hasItem(studentInfo));
        }

        //Assert student Final Exam
        for (float studentInfo : finalExam) {
            response.then().body("content.finalExam",hasItem(studentInfo));
        }

        //Assert student note
        for (String studentInfo : note) {
            response.then().body("content.note",hasItem(studentInfo));
        }

        //Assert student average info
        for (float studentInfo : averageInfo) {
            response.then().body("content.average",hasItem(studentInfo));
        }

        //Assert student infoNote
        for (String studentInfo : infoNote) {
            response.then().body("content.infoNote",hasItem(studentInfo));
        }

        response.prettyPrint();
    }

    @And("teacher should be able to update student information")
    public void teacherShouldBeAbleToUpdateStudentInformation() {

        studentInfoUpdatePayload = new StringBuilder();
        studentInfoUpdatePayload.append("{");
        studentInfoUpdatePayload.append("\"absentee\": ").append(15).append(",");
        studentInfoUpdatePayload.append("\"educationTermId\": ").append(2).append(",");
        studentInfoUpdatePayload.append("\"finalExam\": ").append(7.0).append(",");
        studentInfoUpdatePayload.append("\"infoNote\": ").append("\"Excellent Work! Keep it up.\"").append(",");
        studentInfoUpdatePayload.append("\"lessonId\": ").append(1).append(",");
        studentInfoUpdatePayload.append("\"midtermExam\": ").append(6.0);
        studentInfoUpdatePayload.append("}");

        //https://managementonschools.com/app/studentInfo/update/2983
        response = given(spec)
                .body(studentInfoUpdatePayload.toString() )
                .pathParams("first", "studentInfo", "second", "update", "third", studentId)
                .put("/{first}/{second}/{third}")
                .then()
                .body("message", equalTo("Student Info updated Successfully") )
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        System.out.println("=======================================");
        response.prettyPrint();
    }

    @And("teacher should be able to delete student information")
    public void teacherShouldBeAbleToDeleteStudentInformation() {
        //https://managementonschools.com/app/studentInfo/delete/{id} 1744

        response = given(spec)
                .pathParams(
                        "first", "studentInfo",
                        "second", "delete",
                        "third", deleteStudentById)
                .delete("/{first}/{second}/{third}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Student Info deleted Successfully") )
                .extract().response();
        System.out.println("============================\n" +
                "DELETED" +
                "============================");
        response.prettyPrint();
    }
}