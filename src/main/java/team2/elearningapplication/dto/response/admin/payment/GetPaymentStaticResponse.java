package team2.elearningapplication.dto.response.admin.payment;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetPaymentStaticResponse {
    @NotNull
    private List<Double> revenueForMonth;

}
