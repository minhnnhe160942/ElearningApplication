package team2.elearningapplication.dto.request.user.lesson;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LessonCompletedRequest {
    @NotBlank
    private String username;
    @NotNull
    private int lessonId;
}
