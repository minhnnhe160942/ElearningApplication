package team2.elearningapplication.dto.response.user.payment;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ResponsePayment {
    @NotEmpty
    List<GetPaymentByUserResponse> listPayment;
}
