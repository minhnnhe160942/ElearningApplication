package team2.elearningapplication.dto.response.user.post;

import lombok.Data;
import team2.elearningapplication.entity.Post;
import team2.elearningapplication.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetPostByCourseIdResponse {
    @NotEmpty
    private List<Post> postList;
}
