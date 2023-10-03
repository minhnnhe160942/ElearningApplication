package team2.elearningapplication.dto.response.admin.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateCourseResponse {
    @NotBlank
    private String message;
}
