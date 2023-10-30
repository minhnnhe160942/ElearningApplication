package team2.elearningapplication.dto.request.admin.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAnswerRequest {

    @NotNull
    private int questionID;
    @NotEmpty
    private List<AnswerData> listAnswer;

}
