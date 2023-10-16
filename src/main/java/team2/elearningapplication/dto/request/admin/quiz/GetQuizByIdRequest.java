package team2.elearningapplication.dto.request.admin.quiz;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetQuizByIdRequest {
    @NotNull
    private int id;
}
