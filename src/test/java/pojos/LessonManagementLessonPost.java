package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class LessonManagementLessonPost {

        /*
          {
             {
          "day": "MONDAY",
          "educationTermId": 1,
          "lessonIdList": [
            2
          ],
          "startTime": "13:00",
          "stopTime": "22:00"
        }
         */
        private String day;
        private int educationTermId;
        private ArrayList<Integer> lessonIdList;
        private String startTime;
        private String stopTime;

        public LessonManagementLessonPost(String day, int educationTermId, ArrayList<Integer> lessonIdList, String startTime, String stopTime) {
            this.day = day;
            this.educationTermId = educationTermId;
            this.lessonIdList = lessonIdList;
            this.startTime = startTime;
            this.stopTime = stopTime;
        }

        public LessonManagementLessonPost() {
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getEducationTermId() {
            return educationTermId;
        }

        public void setEducationTermId(int educationTermId) {
            this.educationTermId = educationTermId;
        }

        public ArrayList<Integer> getLessonIdList() {
            return lessonIdList;
        }

        public void setLessonIdList(ArrayList<Integer> lessonIdList) {
            this.lessonIdList = lessonIdList;
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

        @Override
        public String toString() {
            return "LessonManagementLessonPost{" +
                    "day='" + day + '\'' +
                    ", educationTermId=" + educationTermId +
                    ", lessonIdList=" + lessonIdList +
                    ", startTime='" + startTime + '\'' +
                    ", stopTime='" + stopTime + '\'' +
                    '}';
        }
    }

