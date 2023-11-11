package team2.elearningapplication.dto.response.user.quiz;

import lombok.Data;
import team2.elearningapplication.entity.Quiz;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetQuizByLessonIdResponse {
    @NotEmpty
    private List<Quiz> quizList;
}
