package stepdefinitions.apiStepDefinitions;

import base_url.BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactMessagePojo;
import pojos.ContactMessageResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Api_US03_ContactMessage_StepDefs extends BaseUrl {
   /*
   Given
      url from baseUrl
    And
      Request body:
        {
          "email": "abd@ab.com",
          "message": "This is text",
          "name": "Robert Smith",
          "subject": "Registration"
        }
  When
        Send post request
  Then
        Status code is 200
  And
        Response body should be like:
        {
        "object": {
            "name": "Robert Smith",
            "email": "abd@ab.com",
            "subject": "Registration",
            "message": "This is text",
            "date": "2023-09-13"
        },
        "message": "Contact Message Created Successfully",
        "httpStatus": "CREATED"
        }
    */

    Response response;

    //-------------------- TC01 -----------------------
    @Test
    public void postUS03TC1(){
    studentSetUp();

    //Set the url
    spec.pathParams("first","contactMessages", "second", "save");

    //Set the expected data
    ContactMessagePojo expectedData = new ContactMessagePojo("abd@ab.com", "This is text", "Robert Smith", "Registration");

    //Send the request and get the response
    response = given(spec).body(expectedData).post("{first}/{second}");
    response.prettyPrint();

    //Do Assertion
    ContactMessageResponsePojo actualData = response.as(ContactMessageResponsePojo.class);

    assertEquals(200, response.statusCode());
    assertEquals(expectedData.getEmail(), actualData.getObject().getEmail());
    assertEquals(expectedData.getMessage(), actualData.getObject().getMessage());
    assertEquals(expectedData.getName(), actualData.getObject().getName());
    assertEquals(expectedData.getSubject(), actualData.getObject().getSubject());

    //Additional assertion for the response body
    assertEquals("Contact Message Created Successfully", actualData.getMessage());
    assertEquals("CREATED", actualData.getHttpStatus());

    }
}
