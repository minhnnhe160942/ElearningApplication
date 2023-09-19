package team2.elearningapplication.dto.request;

import lombok.Getter;
import lombok.Setter;
import team2.elearningapplication.typesEnum.EnumTypeGender;
import team2.elearningapplication.typesEnum.EnumTypeRole;

import java.time.LocalDate;

@Setter
@Getter
public class CreateUserRequestDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private EnumTypeRole role;
    private String fullName;
    private EnumTypeGender gender;
    private LocalDate dateOfBirth;

    public CreateUserRequestDTO(String username, String password, String email, String phone, EnumTypeRole role, String fullName, EnumTypeGender gender, LocalDate dateOfBirth) {
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
