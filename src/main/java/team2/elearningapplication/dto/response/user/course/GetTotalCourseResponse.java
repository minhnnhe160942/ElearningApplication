package team2.elearningapplication.dto.response.user.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class GetTotalCourseResponse {
    @NotNull
    private int totalCourse;
}
