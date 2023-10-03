package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import pojos.CreateTeacherPojo;
import io.restassured.response.Response;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Api_US14 {

    CreateTeacherPojo createTeacherPojo;
    Response response;

    int userId;
    @Then("create teacher with valid information")
    public void create_teacher_with_valid_information() {
        createTeacherPojo = new CreateTeacherPojo();
        createTeacherPojo.createTeacher();

        //https://managementonschools.com/app/teachers/save
         response = given(spec)
                 .pathParams("first", "teachers", "second", "save")
                 .body(createTeacherPojo.createTeacherPayLoad() )
                 .post("/{first}/{second}")
                 .then()
                 .statusCode(200)
                 .body("object.username", equalTo(createTeacherPojo.getUsername() ) )
                 .body("object.name", equalTo(createTeacherPojo.getName() ) )
                 .body("object.surname", equalTo(createTeacherPojo.getSurname() ) )
                 .body("object.birthDay", equalTo(createTeacherPojo.getBirthday() ) )
                 .body("object.email", equalTo(createTeacherPojo.getEmail() ) )
                 .body("message", equalTo("Teacher saved successfully") )
                 .contentType(ContentType.JSON)
                 .extract().response();

        response.prettyPrint();

        //Update userId field global scope
         userId = response.jsonPath().getInt("object.userId");
         System.out.println("userId: " + userId);
    }

    @Then("confirm that the teacher information is accessible in api")
    public void confirm_that_the_teacher_information_is_accessible_in_api() {
        //https://managementonschools.com/app/teachers/getSavedTeacherById/{id}

        response = given(spec)
                .pathParams(
                        "first", "teachers",
                        "second", "getSavedTeacherById",
                        "third", userId
                )
                .get("/{first}/{second}/{third}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("object.username", equalTo(createTeacherPojo.getUsername() ) )
                .body("object.email", equalTo(createTeacherPojo.getEmail() ) )
                .body("object.lessonsProgramList[0].lesson[0].lessonId", notNullValue() )
                .body("object.lessonsProgramList[0].lesson[0].lessonName", notNullValue() )
                .body("message", equalTo("Teacher successfully found") )
                .extract().response();

        response.prettyPrint();
    }

    @And("update the teacher information")
    public void updateTheTeacherInformation() {
        createTeacherPojo = new CreateTeacherPojo();
        createTeacherPojo.createTeacher();

        //https://managementonschools.com/app/teachers/update/13 PUT
        response = given(spec).pathParams(
                "first", "teachers",
                "second", "update",
                "third", userId
        )
                .body(createTeacherPojo.createTeacherPayLoad() )
                .put("/{first}/{second}/{third}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Teacher updated Successful") )
                .extract().response();

        System.out.println("===== UPDATED =====");
        response.prettyPrint();
    }
}
