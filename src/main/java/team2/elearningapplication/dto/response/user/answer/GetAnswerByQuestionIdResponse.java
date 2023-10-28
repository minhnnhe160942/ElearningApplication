package team2.elearningapplication.dto.response.user.answer;

import lombok.Data;
import team2.elearningapplication.entity.Answer;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetAnswerByQuestionIdResponse {
    @NotEmpty
    private List<Answer> answerList;
}

