package team2.elearningapplication.dto.request.user.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class SearchCourseByNameAndCategoryRequest {
    @NotBlank
    private String keyword;
}
