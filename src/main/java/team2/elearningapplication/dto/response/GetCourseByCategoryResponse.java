package team2.elearningapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCourseByCategoryResponse {
    private List<Course> listCourse;
}
