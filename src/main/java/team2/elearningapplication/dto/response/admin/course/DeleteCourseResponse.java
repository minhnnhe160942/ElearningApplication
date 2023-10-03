package team2.elearningapplication.dto.response.admin.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteCourseResponse {
    @NotBlank
    private String message;
}
