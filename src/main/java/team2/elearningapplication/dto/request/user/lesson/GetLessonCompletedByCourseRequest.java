package team2.elearningapplication.dto.request.user.lesson;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetLessonCompletedByCourseRequest {
    @NotEmpty
    private int courseId;
    @NotBlank
    private String username;
}
