package team2.elearningapplication.dto.request.admin.payment;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetPaymentStaticRequest {
    private Integer month;
    @NotNull
    private Integer year;
}
