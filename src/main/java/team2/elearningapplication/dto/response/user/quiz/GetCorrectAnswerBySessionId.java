package team2.elearningapplication.dto.response.user.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2.elearningapplication.entity.Answer;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorrectAnswerBySessionId {
    List<Answer> answerList;
}
