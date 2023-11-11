package team2.elearningapplication.dto.request.admin.payment;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetPaymentByCourseRequest {
    @NotNull
    private double revenue;
    @NotNull
    private int courseId;
    private Integer month;
    @NotNull
    private Integer year;
}
