package team2.elearningapplication.dto.request.user.question;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetQuestionByQuizIDRequest {
    @NotNull
    private int quizId;
}
