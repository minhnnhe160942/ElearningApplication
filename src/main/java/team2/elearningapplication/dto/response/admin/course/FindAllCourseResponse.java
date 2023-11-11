package team2.elearningapplication.dto.response.admin.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FindAllCourseResponse {
    @NotBlank
    private String message;
    @NotEmpty
    private List<Course> listCourse;
}
