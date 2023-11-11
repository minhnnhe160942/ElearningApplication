package team2.elearningapplication.dto.response.user.question;

import lombok.Data;
import team2.elearningapplication.entity.Question;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetQuestionByQuizIdResponse {
    @NotEmpty
    private List<Question> questionList;
}
