package team2.elearningapplication.dto.request.user.post;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Data
@Getter
public class GetPostByCourseIdRequest {
    @NotNull
    private int courseId;
    @NotNull
    private boolean isDeleted;
}
