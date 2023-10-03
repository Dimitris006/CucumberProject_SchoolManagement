package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static base_url.BaseUrl.spec;
import static base_url.BaseUrl.viceDeanSetUp;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Api_US16_ViceDeanMessageUpdate {

 Response response;

 @Given("send get request to get all messages")
 public void send_get_request_to_get_all_messages() {
  viceDeanSetUp();
  spec.pathParams("first", "contactMessages", "second", "getAll").queryParams("page", 0, "size", 5, "sort", "date", "type", "desc");
  response = given(spec).get("{first}/{second}");
  //response.prettyPrint();
 }
 @Then("validate ID, date, email , message, name, subject by API")
 public void validate_id_date_email_message_name_subject_by_api() {
  assertEquals(200, response.statusCode());

  JsonPath jsonPath = response.jsonPath();
  List<String> actualName = jsonPath.getList("content.findAll{it.name}.name");
  List<String> actualMessage = jsonPath.getList("content.findAll{it.message}.message");
  List<String> actualEmail = jsonPath.getList("content.findAll{it.email}.email");
  List<String> actualDate = jsonPath.getList("content.findAll{it.date}.date");
  List<String> actualSubject = jsonPath.getList("content.findAll{it.subject}.subject");

  System.out.println("Name = " + actualName);
  System.out.println("Message = " + actualMessage);
  System.out.println("Email = " + actualEmail);
  System.out.println("Date= " + actualDate);
  System.out.println("Subject= " + actualSubject);
 }
 @Then("validate message is deleted")
 public void validateMessageIsDeleted() {
  List<Object> objectList =   response.jsonPath().getList("content.findAll{it.message=='XXXXXXXXXXXXXXXX'}");
  System.out.println("objectList = " + objectList);
  assertTrue(objectList.isEmpty());
 }


}
