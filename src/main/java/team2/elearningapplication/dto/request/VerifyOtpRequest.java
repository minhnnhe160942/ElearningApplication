package team2.elearningapplication.dto.request;

import javax.validation.constraints.NotBlank;
<<<<<<< HEAD
=======
import javax.validation.constraints.NotNull;
>>>>>>> main

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerifyOtpRequest {
    @NotBlank
    private String otp;
<<<<<<< HEAD

    @NotBlank
=======
    @NotNull
>>>>>>> main
    private int userId;
}
