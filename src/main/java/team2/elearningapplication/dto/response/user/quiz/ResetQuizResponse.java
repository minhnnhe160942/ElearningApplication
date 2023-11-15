package team2.elearningapplication.dto.response.user.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResetQuizResponse {
    @NotNull
    private int newSessionId;
}
