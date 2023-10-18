package team2.elearningapplication.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class ResendOtpRequest {
    @NotBlank
    private String email;
}
