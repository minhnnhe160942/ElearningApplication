package team2.elearningapplication.dto.request.user.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCourseByUserRequest {
    @NotBlank
    private String username;
}
