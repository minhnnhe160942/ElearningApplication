package team2.elearningapplication.dto.request.admin.answer;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetAnswerByIdRequest {
    @NotNull
    private int id;
}
