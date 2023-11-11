package team2.elearningapplication.dto.response.user.answer;

import lombok.Data;
import team2.elearningapplication.entity.Answer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetAnswerByQuestionIdResponse {

    @NotNull
    private int answerId;
    @NotBlank
    private String answerContent;
}

