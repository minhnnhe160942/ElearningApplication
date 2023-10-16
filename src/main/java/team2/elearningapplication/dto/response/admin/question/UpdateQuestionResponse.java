package team2.elearningapplication.dto.response.admin.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.Enum.EnumQuestionType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateQuestionResponse {
    @NotNull
    private int questionID;
    @NotNull
    private int quizID;
    @NotBlank
    private String questionName;
    @NotNull
    private EnumQuestionType questionType;
}
