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
public class AddQuestionRequest {
    @NotBlank
    private String question;
    @NotBlank
    private int correctAnswerId;
    @NotBlank
    private int quiz_id;
}
