package team2.elearningapplication.dto.response.user.lesson;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GetTrackingCourse {
    @NotNull
    private int lessonCompleted;
    @NotBlank
    private int totalLesson;
}
