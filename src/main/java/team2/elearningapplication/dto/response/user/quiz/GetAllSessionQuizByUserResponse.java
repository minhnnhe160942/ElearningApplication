package team2.elearningapplication.dto.response.user.quiz;

import lombok.Data;
import team2.elearningapplication.entity.HistoryQuizUser;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetAllSessionQuizByUserResponse {
    @NotEmpty
    List<HistoryQuizUser> listQuiz;

}
