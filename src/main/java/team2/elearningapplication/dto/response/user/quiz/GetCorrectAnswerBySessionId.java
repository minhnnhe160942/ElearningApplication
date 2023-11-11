package team2.elearningapplication.dto.response.user.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2.elearningapplication.dto.response.user.answer.AnswerTakeQuizResponse;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorrectAnswerBySessionId {
    @NotEmpty
    List<AnswerTakeQuizResponse> answerListCorrect;
    @NotEmpty
    List<AnswerTakeQuizResponse> answerListIncorrect;
}
