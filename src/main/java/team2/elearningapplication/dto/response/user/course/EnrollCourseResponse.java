package team2.elearningapplication.dto.response.user.course;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EnrollCourseResponse {
    @NotNull
    private int orderId;
    @NotBlank
    private String urlPayment;
}
