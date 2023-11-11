package team2.elearningapplication.dto.response.user.payment;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class GetPaymentByUserResponse {
    @NotNull
    private LocalDateTime createdAt;
    @NotBlank
    private String status;
    @NotNull
    private double amount;
    @NotBlank
    private String courseName;
}
