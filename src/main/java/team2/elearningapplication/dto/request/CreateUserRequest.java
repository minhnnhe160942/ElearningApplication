package team2.elearningapplication.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import team2.elearningapplication.Enum.EnumTypeGender;
import team2.elearningapplication.Enum.EnumTypeRole;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;

    private EnumTypeRole role = EnumTypeRole.STUDENT;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")

}