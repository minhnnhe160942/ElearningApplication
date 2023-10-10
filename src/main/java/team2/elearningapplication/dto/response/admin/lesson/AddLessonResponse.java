package team2.elearningapplication.dto.response.admin.lesson;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AddLessonResponse {

    @NotNull
    private int lessonID;
    @NotNull
    private int ordNumber;
    @NotBlank
    private String courseName;
    @NotBlank
    private String linkContent;
    @NotBlank
    private String description;
    @NotNull
    private LocalDateTime createdAt;
}
