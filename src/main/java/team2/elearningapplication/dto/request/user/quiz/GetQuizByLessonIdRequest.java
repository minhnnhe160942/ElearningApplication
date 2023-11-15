package team2.elearningapplication.dto.request.user.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetQuizByLessonIdRequest {
    @NotNull
    private int lessonId;
}
