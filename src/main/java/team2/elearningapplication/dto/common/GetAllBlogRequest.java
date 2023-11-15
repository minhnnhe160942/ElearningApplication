package team2.elearningapplication.dto.common;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetAllBlogRequest {
    @NotNull
    private boolean deleted;
}
