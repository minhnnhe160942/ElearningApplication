package team2.elearningapplication.dto.request.admin;

import lombok.Data;
import team2.elearningapplication.Enum.EnumTypeRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SetRoleUserRequest {
    @NotBlank
    private String username;
    @NotNull
    private EnumTypeRole typeRole;
}
