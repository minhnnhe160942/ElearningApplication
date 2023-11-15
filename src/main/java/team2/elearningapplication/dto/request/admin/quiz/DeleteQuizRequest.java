package team2.elearningapplication.dto.request.admin.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteQuizRequest {
    @NotBlank
    private String username;
    @NotNull
    private int quizID;
}
