package team2.elearningapplication.dto.response.admin.blog;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateBlogResponse {
    @NotBlank
    private String message;
}
