package team2.elearningapplication.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
=======
import org.springframework.format.annotation.DateTimeFormat;
>>>>>>> main
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
<<<<<<< HEAD
    @NotNull
    private EnumTypeRole role;
=======
//    @NotNull
    private EnumTypeRole role = EnumTypeRole.STUDENT;
>>>>>>> main
    @NotBlank
    private String fullName;
    @NotNull
    private EnumTypeGender gender;
    @NotNull
<<<<<<< HEAD
=======
    @DateTimeFormat(pattern = "dd/MM/yyyy")
>>>>>>> main
    private LocalDate dateOfBirth;


}
