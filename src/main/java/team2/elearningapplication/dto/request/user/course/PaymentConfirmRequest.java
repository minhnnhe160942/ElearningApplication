package team2.elearningapplication.dto.request.user.course;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PaymentConfirmRequest {
    @NotBlank
    private String returUrl;
    @NotNull
    private int orderId;

}
