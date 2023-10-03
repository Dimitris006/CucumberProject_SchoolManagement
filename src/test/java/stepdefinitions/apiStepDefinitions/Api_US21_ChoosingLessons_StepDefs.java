package stepdefinitions.apiStepDefinitions;

import base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.LessonChoosingPojo;
import pojos.LessonChoosingResponsePojo;
import utils.ObjectMapperUtils;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Api_US21_ChoosingLessons_StepDefs extends BaseUrl {
   /*
   Given
      url from baseUrl
   And
      Request body:
        {
          "lessonProgramId": [
            49
          ]
        }
   When
        Send post request
   Then
        Status code is 200
   And
        Response body should be like:
        {
            "object": {
                "userId": 1449,
                "username": "samcarter",
                "name": "Sam",
                "surname": "Carter",
                "birthDay": "2023-08-28",
                "birthPlace": "UK",
                "phoneNumber": "111-999-9999",
                "gender": "MALE",
                "studentNumber": 2336,
                "motherName": "abc",
                "fatherName": "abc",
                "email": "samc@gmail.com",
                "active": true
            },
            "message": "Lesson added to Student",
            "httpStatus": "CREATED"
        }
    */

    Response response;
    LessonChoosingPojo expectedData;

    //-------------------- TC01 -----------------------
    @Given("send post request to select a lesson from lessons page")
    public void send_post_request_to_select_a_lesson_from_lessons_page() {
        //Set the url
        spec.pathParams("first", "students", "second", "chooseLesson");

        //Set the expected data
        expectedData = new LessonChoosingPojo(Arrays.asList(45));
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

    }
    @Then("validate lesson is added to list or error message about double booking")
    public void validate_lesson_is_added_to_list_or_error_message_about_double_booking() {
        //Do Assertion
//        LessonChoosingResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), LessonChoosingResponsePojo.class);
//        System.out.println("actual data "+actualData);
//        assertEquals(200, response.statusCode());
//        assertEquals("Lesson added to Student", actualData.getMessage());
//        assertEquals("CREATED", actualData.getHttpStatus());
        if (response.equals("Lesson added to Student")) {
            response
                    .then()
                    .statusCode(200)
                    .body("message", equalTo("Lesson added to Student"),
                            "httpStatus", equalTo("CREATED"));
        } else {
            response
                    .then()
                    .statusCode(400)
                    .body("message", equalTo("Error: Course schedule cannot be selected for the same hour and day"));
        }
    }
}
