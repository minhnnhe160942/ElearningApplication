package team2.elearningapplication.dto.request.user.blog;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddBlogRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String linkThumnail;
}
