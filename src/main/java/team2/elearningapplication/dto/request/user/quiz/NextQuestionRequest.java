package team2.elearningapplication.dto.request.user.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NextQuestionRequest {
    @NotNull
    private int ordQuestion;
    @NotNull
    private int quizId;
    private int answerId;
}
