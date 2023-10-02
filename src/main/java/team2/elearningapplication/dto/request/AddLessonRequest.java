package team2.elearningapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonRequest {
    @NotBlank
    private int ordNumber;
    @NotBlank
    private Course course;
    @NotBlank
    private String linkContent;
    @NotBlank
    private String description;
    @NotBlank
    private ZonedDateTime createdAt;
}
