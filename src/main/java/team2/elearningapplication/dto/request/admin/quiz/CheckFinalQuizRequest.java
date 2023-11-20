package team2.elearningapplication.dto.request.admin.quiz;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CheckFinalQuizRequest {
    @NotNull
    private int courseId;
}
