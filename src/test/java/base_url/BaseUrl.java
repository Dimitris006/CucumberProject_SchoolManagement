package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;
import static utilities.Authentication.*;
public class BaseUrl {
    public static RequestSpecification spec;
    static public void adminSetUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization", generateTokenAdmin()).
                setBaseUri(ConfigReader.getProperty("apiUrl")).build();
    }
    public static void deanSetUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization",  generateTokenDean()).
                setBaseUri(ConfigReader.getProperty("apiUrl")).build();
    }
    public static void viceDeanSetUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization",  generateTokenViceDean()).
                setBaseUri(ConfigReader.getProperty("apiUrl")).build();
    }
    public static void teacherSetUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization",  generateTokenTeacher()).
                setBaseUri(ConfigReader.getProperty("apiUrl")).build();
    }
    /**
     * Please do not delete dunkTeacherSetUp() -- required for US.
     */
    public static void dunkTeacherSetUp() {
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("Authorization", generateTokenDunkTeacher()).build();
    }

        public static void teacherAnnaSetUp() {
            spec = new RequestSpecBuilder().
                    setContentType(ContentType.JSON).
                    addHeader("Authorization", generateTokenTeacherAnna()).

                    setBaseUri(ConfigReader.getProperty("apiUrl")).build();
        }

        public static void studentSetUp () {
            spec = new RequestSpecBuilder().
                    setContentType(ContentType.JSON).
                    addHeader("Authorization", generateTokenStudent()).
                    setBaseUri(ConfigReader.getProperty("apiUrl")).build();
        }
    }

