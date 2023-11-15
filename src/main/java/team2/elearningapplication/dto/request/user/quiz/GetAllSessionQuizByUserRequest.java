package team2.elearningapplication.dto.request.user.quiz;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GetAllSessionQuizByUserRequest {
    @NotBlank
    private String username;
    @NotNull
    private int quizId;

}
