package team2.elearningapplication.dto.request.user.course;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PaymentConfirmRequest {
    @NotNull
    private int orderId;
    @NotBlank
    private String amount;
    @NotBlank
    private String responseCode;

}
