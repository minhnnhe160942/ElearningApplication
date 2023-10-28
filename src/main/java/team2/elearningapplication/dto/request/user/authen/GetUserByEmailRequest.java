package team2.elearningapplication.dto.request.user.authen;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetUserByEmailRequest {
    @NotBlank
    private String email;
}
