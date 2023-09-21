package team2.elearningapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import team2.elearningapplication.Enum.EnumTypeGender;
import team2.elearningapplication.Enum.EnumTypeRole;

import java.time.LocalDate;

@Setter
@Getter
public class CreateUserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotNull
    private EnumTypeRole role;
    @NotBlank
    private String fullName;
    @NotNull
    private EnumTypeGender gender;
    @NotNull
    private LocalDate dateOfBirth;

    public CreateUserRequest(String username, String password, String email, String phone, EnumTypeRole role, String fullName, EnumTypeGender gender, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
