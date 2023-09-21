package team2.elearningapplication.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team2.elearningapplication.Enum.EnumTypeGender;
import team2.elearningapplication.Enum.EnumTypeRole;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class GetOTPRequest {
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

}
