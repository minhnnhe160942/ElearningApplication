package team2.elearningapplication.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import team2.elearningapplication.Enum.EnumTypeGender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChangeProfileRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String fullName;
    @NotBlank
    private String phoneNum;
    @NotNull
    private EnumTypeGender gender;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}
