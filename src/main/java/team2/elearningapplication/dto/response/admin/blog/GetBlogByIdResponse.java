package team2.elearningapplication.dto.response.admin.blog;

import lombok.Data;
import team2.elearningapplication.entity.Blog;

import javax.validation.constraints.NotNull;

@Data
public class GetBlogByIdResponse {
    @NotNull
    private Blog blog;
}
