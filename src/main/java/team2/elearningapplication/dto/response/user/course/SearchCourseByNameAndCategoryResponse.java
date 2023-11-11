package team2.elearningapplication.dto.response.user.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SearchCourseByNameAndCategoryResponse {
    @NotEmpty
    List<Course> courseList;
}
