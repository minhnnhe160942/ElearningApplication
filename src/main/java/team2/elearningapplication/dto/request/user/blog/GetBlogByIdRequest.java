package team2.elearningapplication.dto.request.user.blog;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetBlogByIdRequest {
    @NotNull
    private int blogId;
}
