package team2.elearningapplication.dto.response.admin.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CheckFinalQuizResponse {
    @NotNull
    private boolean isFinalQuiz;
}
