package team2.elearningapplication.dto.response.admin.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteQuizResponse {
    @NotNull
    private int quizID;
    @NotBlank
    private String quizName;
    @NotNull
    private int lessonID;
    @NotBlank
    private String lessonName;
    @NotNull
    private LocalDateTime updateAt;
}
