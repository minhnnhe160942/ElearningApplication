package team2.elearningapplication.dto.response.user.lesson;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetLessonCompletedByCourseResponse {
    @NotEmpty
    List<Integer> listLessonId;
}
