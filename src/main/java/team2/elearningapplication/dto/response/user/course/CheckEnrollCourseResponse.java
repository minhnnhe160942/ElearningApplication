package team2.elearningapplication.dto.response.user.course;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CheckEnrollCourseResponse {
    @NotNull
    private boolean isEnrollCourse;

}
