package team2.elearningapplication.dto.response.admin;

import lombok.Data;
import team2.elearningapplication.entity.User;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetUserResponse {
    @NotEmpty
    private List<User> userList;
}
