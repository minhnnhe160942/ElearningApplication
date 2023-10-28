package team2.elearningapplication.dto.request.user.payment;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GetPaymentByUserRequest {
    @NotBlank
    private String username;
}
