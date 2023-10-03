package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonChoosingPojo {

    //Create private fields
    private List<Integer> lessonProgramId;

    //Create default and parameterized constructors
    public LessonChoosingPojo() {
    }

    public LessonChoosingPojo(List<Integer> lessonProgramId) {
        this.lessonProgramId = lessonProgramId;
    }

    //Create setters and getters
    public List<Integer> getLessonProgramId() {
        return lessonProgramId;
    }

    public void setLessonProgramId(List<Integer> lessonProgramId) {
        this.lessonProgramId = lessonProgramId;
    }

    //Create toString() method
    @Override
    public String toString() {
        return "LessonChoosingPojo{" +
                "lessonProgramId=" + lessonProgramId +
                '}';
    }
}
