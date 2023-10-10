package team2.elearningapplication.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {


    @NotBlank
    private String otp;

    @NotBlank
    private String email;

    @NotBlank
    private String password;


}
