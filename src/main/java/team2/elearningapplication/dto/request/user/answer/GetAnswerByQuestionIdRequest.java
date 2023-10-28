package team2.elearningapplication.dto.request.user.answer;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetAnswerByQuestionIdRequest {
    @NotNull
    private int questionId;
}
