package pojos;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonManagementObjectPojo {

    /*
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
     */

    private int lessonProgramId;//1712
    private String startTime;//13:00:00
    private String stopTime;
    private ArrayList<LessonManagementLessonName> lessonName;
    private String day;//MONDAY

    public LessonManagementObjectPojo() {
    }

    public LessonManagementObjectPojo(int lessonProgramId, String startTime, String stopTime, ArrayList<LessonManagementLessonName> lessonName, String day) {
        this.lessonProgramId = lessonProgramId;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.lessonName = lessonName;
        this.day = day;
    }

    public int getLessonProgramId() {
        return lessonProgramId;
    }

    public void setLessonProgramId(int lessonProgramId) {
        this.lessonProgramId = lessonProgramId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public ArrayList<LessonManagementLessonName> getLessonName() {
        return lessonName;
    }

    public void setLessonName(ArrayList<LessonManagementLessonName> lessonName) {
        this.lessonName = lessonName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "LessonManagementObjectPojo{" +
                "lessonProgramId=" + lessonProgramId +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", lessonName=" + lessonName +
                ", day='" + day + '\'' +
                '}';
    }
}