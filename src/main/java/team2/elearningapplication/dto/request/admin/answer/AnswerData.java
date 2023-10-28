package team2.elearningapplication.dto.request.admin.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.Enum.EnumQuestionType;
import team2.elearningapplication.entity.Answer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnswerData {
    @NotBlank
    private String username;
    @NotNull
    private int questionID;
    @NotBlank
    private String answerName;
    @NotNull
    private boolean isCorrect;
}
