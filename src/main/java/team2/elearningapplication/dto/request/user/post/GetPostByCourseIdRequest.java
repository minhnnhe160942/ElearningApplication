package team2.elearningapplication.dto.request.user.post;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetPostByCourseIdRequest {
    @NotNull
    private int courseId;
}
