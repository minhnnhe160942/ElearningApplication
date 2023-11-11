package team2.elearningapplication.dto.response.user.lesson;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LessonCompletedResponse {
    @NotNull
    private boolean isDone;
    @NotBlank
    private String message;
}
