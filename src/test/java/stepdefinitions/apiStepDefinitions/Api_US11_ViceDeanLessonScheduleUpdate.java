package stepdefinitions.apiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.LessonManagementLessonName;
import pojos.LessonManagementLessonPost;
import pojos.LessonManagementObjectPojo;
import pojos.LessonManagementPojo;
import utilities.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class Api_US11_ViceDeanLessonScheduleUpdate {
    LessonManagementLessonPost objectPost;
    LessonManagementObjectPojo object;
    LessonManagementPojo expectedData;
    LessonManagementLessonName lessonName;
    Response response;
    static int createdId;

    @When("send getAll request for lesson Program")
    public void send_get_request_for_lesson_program() {
        //set the url
        spec.pathParams("first", "lessonPrograms", "second","getAll");
        //Send the request and get the response
        response= given(spec).when().get("{first}/{second}");
        //response.prettyPrint();
    }
    @Then("validate that response data includes the lesson program")
    public void validate_that_response_data_includes_the_lesson_program() {
        //Do Assertion
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();

        List<String> lessonNames = jsonPath.getList("lessonName.lessonName");
        List<Integer> lessonIds = jsonPath.getList("lessonName.lessonId");
        List<Integer> lessonProgramIds = jsonPath.getList("lessonProgramId");
        List<String> startTimes = jsonPath.getList("startTime");
        List<String> stopTimes = jsonPath.getList("stopTime");
        List<String> days = jsonPath.getList("day");
        System.out.println("lessonNames = " + lessonNames );
        System.out.println("lessonIds = " + lessonIds);
        System.out.println("lessonProgramIds = " + lessonProgramIds);
        System.out.println("startTimes= "+ startTimes);
        System.out.println("stopTimes= "+ stopTimes);
        System.out.println("days= "+ days);

        ArrayList<String> lesson = new ArrayList<>();
        lesson.add("ABCD");
        assertTrue(lessonNames.contains(lesson));
        ArrayList<Integer> lessonId = new ArrayList<>();
        lessonId.add(07);
        assertTrue(lessonIds.contains(lessonId));
          }
    @When ("send post request for lesson program")
    public void viceDeanSendsPutRequestForLessonProgram() {
        spec.pathParams("first","lessonPrograms", "second", "save");
        ArrayList<Integer> lessonId = new ArrayList<>();
        lessonId.add(2);
        objectPost =new LessonManagementLessonPost(
                "MONDAY",
                Faker.instance().number().numberBetween(1,6),
                lessonId,
                "13:00","22:00");
        System.out.println("objectPost = " + objectPost);
        lessonName = new LessonManagementLessonName(2,"Java",10,true);
//                "lessonId": 2,
//                "lessonName": "Java",
//                "creditScore": 10,
//                "compulsory": true
        ArrayList<LessonManagementLessonName> lessonNames=new ArrayList<>();
        lessonNames.add(lessonName);
        System.out.println("lessonName = " + lessonName);
        object = new LessonManagementObjectPojo(1728,"13:00","22:00",lessonNames,"MONDAY");
    /*
    "object": {
        "lessonProgramId": 1728,
                "startTime": "13:00:00",
                "stopTime": "22:00:00",
                "lessonName": [
        {
            "lessonId": 2,
                "lessonName": "Java",
                "creditScore": 10,
                "compulsory": true
        }
        ],
        "day": "MONDAY"
      */
        expectedData = new LessonManagementPojo(object,"Created Lesson Program","CREATED");
        response= given(spec).body(objectPost).post("{first}/{second}");
        System.out.println("objectPost = " + objectPost);
        System.out.println("expectedData = " + expectedData);
        //response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        createdId = (Integer.parseInt(jsonPath.getString("object.lessonProgramId")) - 1);
        System.out.println("createdId = " + createdId);
    }
       @Then("send delete request for deleting lesson Program")
    public void sendDeleteRequestForDeletingLessonProgram() {
        spec.pathParams("first","lessonPrograms","second","delete", "third",createdId);

        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("message","Lesson Program Deleted");
        expectedData.put("httpStatus","OK");

       Response response=given(spec).delete("{first}/{second}/{third}");
       response.prettyPrint();
       HashMap actualData= JsonUtils.convertJsonToJava(response.asString(),HashMap.class);

       assertEquals(200, response.getStatusCode());
       assertEquals(expectedData, actualData);
        }
    }

