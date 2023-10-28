package team2.elearningapplication.dto.request.user.authen;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
