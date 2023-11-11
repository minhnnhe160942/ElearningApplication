package team2.elearningapplication.dto.response.admin.payment;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetPaymentStaticResponse {
    @NotNull
    private double revenue;
}
