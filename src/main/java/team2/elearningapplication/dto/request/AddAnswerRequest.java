package team2.elearningapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AddAnswerRequest {
    @NotBlank
    private String answerContent;
    @NotBlank
    private int questionId;
}
