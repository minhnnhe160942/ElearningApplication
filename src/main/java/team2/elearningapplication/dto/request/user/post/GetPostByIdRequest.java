package team2.elearningapplication.dto.request.user.post;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetPostByIdRequest {
    @NotNull
    private int id;
}
