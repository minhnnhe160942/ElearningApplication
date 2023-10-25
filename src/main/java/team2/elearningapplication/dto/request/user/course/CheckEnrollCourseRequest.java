package team2.elearningapplication.dto.request.user.course;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CheckEnrollCourseRequest {
    @NotEmpty
    private int courseId;
    @NotBlank
    private String username;
}
