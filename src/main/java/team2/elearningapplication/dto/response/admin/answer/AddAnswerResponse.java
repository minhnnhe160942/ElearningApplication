package team2.elearningapplication.dto.response.admin.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAnswerResponse {
    @NotNull
    private int id;
    @NotBlank
    private String answerContent;
    @NotNull
    private boolean isCorrect;
    @NotBlank
    private String createdBy;
    @NotBlank
    private String updatedBy;
}
