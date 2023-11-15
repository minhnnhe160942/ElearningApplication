package team2.elearningapplication.dto.response.user.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Course;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PageCourseResponse {
    @NotEmpty
    private List<Course> courseList;
    @NotNull
    private int pageNo;
    @NotNull
    private int pageSize;
    @NotNull
    private int totalElements;
    @NotNull
    private int totalPages;
    @NotNull
    private boolean last;
}
