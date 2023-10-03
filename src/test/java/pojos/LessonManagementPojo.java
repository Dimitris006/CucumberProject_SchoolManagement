package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LessonManagementPojo {

/*
    {
        "object": {
        "lessonProgramId": 1612,
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
    },
        "message": "Created Lesson Program",
            "httpStatus": "CREATED"
    }
*/

    /*
      {
         "compulsory": true,
         "creditScore": 0,
         "lessonName": "string"
       }

     */

    private LessonManagementObjectPojo object;
    private String message;
    private String httpStatus;

    public LessonManagementPojo(LessonManagementObjectPojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public LessonManagementPojo() {
    }

    public LessonManagementObjectPojo getObject() {
        return object;
    }

    public void setObject(LessonManagementObjectPojo object) {
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

    @Override
    public String toString() {
        return "LessonManagementPojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
