package team2.elearningapplication.dto.response.user.lesson;

import lombok.Data;
import team2.elearningapplication.entity.Lesson;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetLessonByCourseIdResponse {
    @NotEmpty
    private List<Lesson> lessonList;
}
