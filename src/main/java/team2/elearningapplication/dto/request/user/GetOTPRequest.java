package team2.elearningapplication.dto.request.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import team2.elearningapplication.Enum.EnumTypeGender;
import team2.elearningapplication.Enum.EnumTypeRole;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetOTPRequest {
    @NotBlank
    private String email;
    @JsonIgnore
    private boolean isCreate;
}
