package team2.elearningapplication.dto.request.admin.course;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FindCourseByDeletedRequest {
    @NotNull
    private boolean deleted;
}
