package team2.elearningapplication.dto.request;

import lombok.*;
import javax.validation.constraints.NotBlank;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateQuestionRequest {
    private int id;
   @NotBlank
    private String question;
   @NotBlank
    private int correctAnswerId;
    @NotBlank
    private int quiz_id;
}
