package team2.elearningapplication.dto.request.admin.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollCourseRequest {

    @NotNull
    private int courseID;
    @NotNull
    private int paymentID;
    @NotNull
    private LocalDateTime createdAt;
}
