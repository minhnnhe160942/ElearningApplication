package team2.elearningapplication.dto.request.user.lesson;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetLessonByCourseIdRequest {
    @NotNull
    private int courseId;

}
