package pojos;

import com.google.gson.Gson;

public class CreateNewLessonPojo {


    /**
     * Successful Response Body:
     * {
     *   "httpStatus": "100 CONTINUE",
     *   "message": "string",
     *   "object": {
     *     "compulsory": true,
     *     "creditScore": 0,
     *     "lessonId": 0,
     *     "lessonName": "string"
     *   }
     * }
     */

    private int lessonId;

    private boolean compulsory;

    private int creditScore;

    private String lessonName;

    // Getter and setter methods
    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public boolean isCompulsory() {
        return compulsory;
    }

    private void setCompulsory(boolean compulsory) {
        this.compulsory = compulsory;
    }

    public int getCreditScore() {
        return creditScore;
    }

    private void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getLessonName() {
        return lessonName;
    }

    private void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }


    /**
     * Required Body:
     * {
     *   "compulsory": true,
     *   "creditScore": 0,
     *   "lessonName": "string"
     * }
     */
    public String createLesson(boolean compulsory, int creditScore, String lessonName) {

        setCompulsory(compulsory);
        setCreditScore(creditScore);
        setLessonName(lessonName);

        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getLessonInfo() {

        Gson json = new Gson();
        return json.toJson(this);
    }
}

