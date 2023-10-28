package team2.elearningapplication.dto.request.admin.question;

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
public class UpdateQuestionRequest {
    @NotBlank
    private String username;
    @NotNull
    private int questionID;
    @NotNull
    private int quizID;
    @NotBlank
    private String questionName;
    @NotNull
    private EnumQuestionType questionType;
    @NotEmpty
    private List<Answer> answers;
    @NotNull
    private boolean deleted;
}
