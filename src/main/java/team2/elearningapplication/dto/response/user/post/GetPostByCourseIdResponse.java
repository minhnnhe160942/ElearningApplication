package team2.elearningapplication.dto.response.user.post;

import lombok.Data;
import team2.elearningapplication.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class GetPostByCourseIdResponse {
    @NotNull
    private int id;
    @NotNull
    private User user;
    @NotNull
    private int courseId;
    @NotBlank
    private String content;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private boolean deleted;
}
