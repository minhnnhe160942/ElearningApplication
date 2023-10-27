package team2.elearningapplication.dto.response.user.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FinishQuizResponse {
    @NotNull
    private int totalCorrect;
    @NotNull
    private int totalInCorrect;
    @NotNull
    private double percent;
}
