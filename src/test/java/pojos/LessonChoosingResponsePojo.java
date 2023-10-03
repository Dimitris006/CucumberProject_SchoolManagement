package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//ignores unrecognized fields
public class LessonChoosingResponsePojo {
    /*
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
    private String object;
    private String message;
    private String httpStatus;

    //Default and parametrized constructors
    public LessonChoosingResponsePojo() {
    }

    public LessonChoosingResponsePojo(String object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    //Setters and Getters
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    //toString() method
    @Override
    public String toString() {
        return "LessonChoosingResponsePojo{" +
                "object='" + object + '\'' +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
