package team2.elearningapplication.dto.response.user.quiz;

import lombok.Data;
import team2.elearningapplication.entity.Question;

import javax.validation.constraints.NotNull;

@Data
public class NextQuestionResponse {
    @NotNull
    private Question question;

}
