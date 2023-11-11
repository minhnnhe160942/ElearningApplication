package team2.elearningapplication.dto.request.user.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResetQuizRequest {
    @NotNull
    private String username;
    @NotNull
    private int sessionId;
}
