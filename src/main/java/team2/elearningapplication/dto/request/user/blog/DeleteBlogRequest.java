package team2.elearningapplication.dto.request.user.blog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DeleteBlogRequest {
    @NotBlank
    private String username;
    @NotNull
    private int blogId;
}
