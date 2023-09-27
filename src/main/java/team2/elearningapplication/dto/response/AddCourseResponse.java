package team2.elearningapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import java.time.ZonedDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCourseResponse {
    private Course course;
}
