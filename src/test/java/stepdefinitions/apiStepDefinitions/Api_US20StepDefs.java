package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.AddMeetExpectedPojo;
import pojos.CreateMeetObjectPojo;
import pojos.CreateMeetPojo;
import pojos.CreateMeetStudentsPojo;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Api_US20StepDefs {
    Response response;
    Response response2;
    Response response3;
    CreateMeetObjectPojo expectedData;
    CreateMeetObjectPojo expectedData2;
    AddMeetExpectedPojo expectedData3;
    CreateMeetPojo actualData;
    CreateMeetPojo actualData2;
    CreateMeetPojo actualData3;
   // Map<String, String> expectedData4;
    List<CreateMeetStudentsPojo> students = new ArrayList<>();
    //CreateMeetStudentsPojo createMeetStudentsPojo;

//    @Given("send post request meet")
//    public void sendPostRequestMeet() {
//
//        spec.pathParams("first","meet","second","save");
//
//        List<Integer> studentIds = new ArrayList<>();
//        studentIds.add(13);
//
//
//        expectedData3 = new AddMeetExpectedPojo("2025-01-01","Test Results2","10:30","11:20",studentIds);
//
//        //Send the request and get the response
//        response3 = given(spec).body(expectedData3).post("{first}/{second}");
//        response3.prettyPrint();
//
//    }
    @Given("send get request to get meet via id")
    public void sendGetRequestToGetMeetViaDescription() {

        spec.pathParams("first","meet","second","getMeetById", "third", 930);


        expectedData = new CreateMeetObjectPojo(13, "Test Results3","2025-01-01","10:00:00","10:20:00",386, "Anne","756-56-8566", students );

        //Send the request and get the response
        response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("validate  description {string} date {string} start_time {string}   stop_time {string} by Api")
    public void validateDescriptionDateStart_timeStop_timeByApi(String description, String date, String start_time, String stop_time) {


        actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CreateMeetPojo.class);

        assertEquals(200, response.statusCode());
        //assertEquals(expectedData.getDescription(), actualData.getObject().getDescription());
        assertEquals(expectedData.getDate(), actualData.getObject().getDate());
        assertEquals(expectedData.getStartTime(), actualData.getObject().getStartTime());
        assertEquals(expectedData.getStopTime(), actualData.getObject().getStopTime());


    }

    @Then("validate created message is seen")
    public void validateCreatedMessageIsSeen() {

        assertEquals("Meet successfully found", actualData.getMessage());
        assertEquals("CREATED", actualData.getHttpStatus());
    }

    @Given("send put request to get meet via id")
    public void sendPutRequestToGetMeetViaId() {

        spec.pathParams("first","meet","second","update", "third", 930);

        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(13);


        expectedData3 = new AddMeetExpectedPojo("2025-01-01","Test Results2","10:00","10:20",studentIds);


        //Send the request and get the response
        response2 = given(spec).body(expectedData3).put("{first}/{second}/{third}");
        response2.prettyPrint();



    }

    @Then("validate  description {string} by Api")
    public void validateDescriptionByApi(String arg0) {

        actualData2 = ObjectMapperUtils.convertJsonToJava(response2.asString(), CreateMeetPojo.class);

        assertEquals(200, response2.statusCode());
        assertEquals(expectedData3.getDescription(), actualData2.getObject().getDescription());

    }

    @Then("validate updated message is seen")
    public void validateUpdatedMessageIsSeen() {

        assertEquals("Meet Updated Successfully", actualData2.getMessage());
        assertEquals("OK", actualData2.getHttpStatus());
    }


//    @Given("send delete request to delete meet")
//    public void sendDeleteRequestToDeleteMeet() {
//
//        spec.pathParams("first","meet","second","delete", "third", 930);
//       // expectedData4 = new HashMap<>();
//
//        response3 = given(spec).delete("{first}/{second}/{third}");
//        response3.prettyPrint();
//
//    }

//    @Then("validate  meet is deleted")
//    public void validateMeetIsDeleted() {
//
//        actualData3 = ObjectMapperUtils.convertJsonToJava(response3.asString(), CreateMeetPojo.class);
//
//        assertEquals(200, response3.statusCode());
//        //assertEquals(expectedData4, actualData);
//
//        assertEquals("Meet deleted successfully",actualData3.getMessage());
//        //Meet deleted successfully
//    }
}
