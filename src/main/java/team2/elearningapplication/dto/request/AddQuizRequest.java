package team2.elearningapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Lesson;
import team2.elearningapplication.entity.Question;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddQuizRequest {

    @NotNull
    private Lesson lesson;
    @NotBlank
    private String name;
    @NotEmpty
    private List<Question> questionList;
}
