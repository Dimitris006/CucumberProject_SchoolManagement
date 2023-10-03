package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public class LessonManagementLessonName {

/*
                "lessonId": 2,
                "lessonName": "Java",
                "creditScore": 10,
                "compulsory": true
        }
 */

        private int  lessonId;  //2
        private String  lessonName; //Java
        private int  creditScore; //10
        private boolean  compulsory; //true



                public LessonManagementLessonName(int lessonId, String lessonName, int creditScore, boolean compulsory) {
            this.lessonId = lessonId;
            this.lessonName = lessonName;
            this.creditScore = creditScore;
            this.compulsory = compulsory;
        }

        public int getLessonId() {
            return lessonId;
        }

        public void setLessonId(int lessonId) {
            this.lessonId = lessonId;
        }

        public String getLessonName() {
            return lessonName;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

        public int getCreditScore() {
            return creditScore;
        }

        public void setCreditScore(int creditScore) {
            this.creditScore = creditScore;
        }

        public boolean isCompulsory() {
            return compulsory;
        }

        public void setCompulsory(boolean compulsory) {
            this.compulsory = compulsory;
        }

        @Override
        public String toString() {
            return "LessonManagementLessonName{" +
                    "lessonId=" + lessonId +
                    ", lessonName='" + lessonName + '\'' +
                    ", creditScore=" + creditScore +
                    ", compulsory=" + compulsory +
                    '}';
        }
    }

