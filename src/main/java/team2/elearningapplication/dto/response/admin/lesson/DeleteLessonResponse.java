package team2.elearningapplication.dto.response.admin.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteLessonResponse {
    @NotNull
    private int lessonID;
    @NotBlank
    private String lessonName;
    @NotNull
    private int ordNumber;
    @NotNull
    private int courseID;
    @NotBlank
    private String linkContent;
    @NotBlank
    private String description;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updateAt;
    @NotBlank
    private String createdBy;
    @NotBlank
    private String updatedBy;
}
