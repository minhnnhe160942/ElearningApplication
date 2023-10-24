package team2.elearningapplication.dto.response.user;

import lombok.Data;
import team2.elearningapplication.entity.User;

import javax.validation.constraints.NotNull;

@Data
public class GetUserByUsernameResponse {
    @NotNull
    private User user;
}
