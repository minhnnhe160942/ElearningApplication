package team2.elearningapplication.dto.request.admin.question;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetQuestionByIdRequest {
    @NotNull
    private int id;
}
