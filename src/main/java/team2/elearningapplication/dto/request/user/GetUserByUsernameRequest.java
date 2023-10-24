package team2.elearningapplication.dto.request.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetUserByUsernameRequest {
    @NotBlank
    private String username;
}
