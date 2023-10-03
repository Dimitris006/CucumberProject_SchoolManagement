package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
public class Authentication {

    public static   String url = ConfigReader.getProperty("authenticationURL");
    //admin
    public static String generateTokenAdmin(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("adminUserName"));
        body.put("password",ConfigReader.getProperty("adminPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }
    //dean
    public static String generateTokenDean(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("deanUserName"));
        body.put("password",ConfigReader.getProperty("deanPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }
    //vice dean
    public static String generateTokenViceDean() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", ConfigReader.getProperty("viceDeanUserName"));
        body.put("password", ConfigReader.getProperty("viceDeanPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return response.jsonPath().getString("token");
    }
    //teacher
    public static String generateTokenTeacher() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", ConfigReader.getProperty("teacherUserName"));
        body.put("password", ConfigReader.getProperty("teacherPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return response.jsonPath().getString("token");
    }


    //please do not delete generateTokenDunkTeacher()
    public static String generateTokenDunkTeacher() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", "w.dunk");
        body.put("password", "!Teacher.123");
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return response.jsonPath().getString("token");
    }


    public static String generateTokenTeacherAnna() {
        Map<String, Object> body = new HashMap<>();
        body.put("username", ConfigReader.getProperty("teacherAnnaUserName"));
        body.put("password", ConfigReader.getProperty("teacherAnnaPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return response.jsonPath().getString("token");
    }

    //student
    public static String generateTokenStudent(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("studentUserName"));
        body.put("password",ConfigReader.getProperty("studentPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }
     //student info
    public static String generateTokenStudentInfo(){
        Map<String, Object> body = new HashMap<>();
        body.put("username",ConfigReader.getProperty("studentInfoUserName"));
        body.put("password",ConfigReader.getProperty("studentInfoPassword"));
        Response response = given().contentType(ContentType.JSON).body(body).post(url);
        return  response.jsonPath().getString("token");
    }
}