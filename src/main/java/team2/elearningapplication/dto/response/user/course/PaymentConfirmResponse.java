package team2.elearningapplication.dto.response.user.course;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PaymentConfirmResponse {
    @NotBlank
    private String status;
}
