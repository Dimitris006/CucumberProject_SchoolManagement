//package stepdefinitions.apiStepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//import static base_url.BaseUrl.spec;
//import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertEquals;
//import static stepdefinitions.uiStepDefinitions.US13_StepDefs.fakeUsername;
//
//public class Api_US01_Guest_User {
//
//    Response response;
//    @Given("send get request to get all guest users")
//    public void sendGetRequestToGetAllGuestUsers() {
////        String url = "https://managementonschools.com/app/guestUser/getAll?page=0&size=10000&sort=name&type=desc";
////        Response response = given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtMDEiLCJpYXQiOjE2OTU0NzcxMjgsImV4cCI6MTY5NTQ4NTc2OH0.vcEbG3tKba7pjmM9JnfFDqdTWglBk13pQCZ3sBMdXqqTEjhWPuqOeGRIEJh8yV_mNqYFavIh5Y61QcQA9tji9A").get(url);
////        response.prettyPrint();
//        //setSpec(); //--> This method must be called before api tests. We will call this before api test on hooks class
//        spec.pathParams("first","guestUser","second","getAll").queryParams("size","10000");
//        Response response = given(spec).get("{first}/{second}");
//        response.prettyPrint();
//
//
//    }
//
//    @Then("validate  username {string} date_of_birth {string}   birth_place {string}   name {string} phone_number {string}  ssn_number {string} surname {string} by API")
//    public void validateUsernameDate_of_birthBirth_placeNamePhone_numberSsn_numberSurnameByAPI(String username, String birthDay, String birthPlace, String name, String phoneNumber, String ssn, String surname) {
//
//        JsonPath jsonPath = response.jsonPath();
//        String actUsername = jsonPath.getList("content.findAll{it.username=='Raven'}.username").get(0).toString();
//        String actSsn = jsonPath.getList("content.findAll{it.username=='Raven'}.ssn").get(0).toString();
//        String actName = jsonPath.getList("content.findAll{it.username=='Raven'}.name").get(0).toString();
//        String actSurname = jsonPath.getList("content.findAll{it.username=='Raven'}.surname").get(0).toString();
//        String actBirthDay= jsonPath.getList("content.findAll{it.username=='Raven'}.birthDay").get(0).toString();
//        String actBirthPlace= jsonPath.getList("content.findAll{it.username=='Raven'}.birthPlace").get(0).toString();
//        String actPhoneNumber= jsonPath.getList("content.findAll{it.username=='Raven'}.phoneNumber").get(0).toString();
//
//
////        String actUsername = jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.username").get(0).toString();
////        String actSsn = jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.ssn").get(0).toString();
////        String actName = jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.name").get(0).toString();
////        String actSurname = jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.surname").get(0).toString();
////        String actBirthDay= jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.birthDay").get(0).toString();
////        String actBirthPlace= jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.birthPlace").get(0).toString();
////        String actPhoneNumber= jsonPath.getList("content.findAll{it.username=='"+fakeUsername+"'}.phoneNumber").get(0).toString();
//
//
//        assertEquals(200, response.statusCode());
//        assertEquals(fakeUsername, actUsername);
//       // assertEquals(fakeSsn, actSsn);
//        assertEquals(name, actName);
//        assertEquals(surname, actSurname);
//        assertEquals(birthDay, actBirthDay);
//        assertEquals(birthPlace, actBirthPlace);
//       // assertEquals(fakePhoneNumber, actPhoneNumber);
//
//
//    }
//}
