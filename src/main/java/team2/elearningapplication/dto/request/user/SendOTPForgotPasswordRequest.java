package team2.elearningapplication.dto.request.user;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SendOTPForgotPasswordRequest {
    @NotBlank
    private String email;

}
