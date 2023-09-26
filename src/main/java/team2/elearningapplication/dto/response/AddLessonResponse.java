package team2.elearningapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonResponse {
    private int ordNumber;
    private Course course;
    private String linkContent;
    private String description;
    private ZonedDateTime createdAt;
}
