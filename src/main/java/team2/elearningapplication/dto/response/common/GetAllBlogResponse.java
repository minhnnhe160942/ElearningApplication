package team2.elearningapplication.dto.response.common;

import lombok.Data;
import team2.elearningapplication.entity.Blog;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetAllBlogResponse {
    @NotEmpty
    private List<Blog> blogList;
}
