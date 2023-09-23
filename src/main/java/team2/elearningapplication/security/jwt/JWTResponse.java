package team2.elearningapplication.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class JWTResponse {
    @NotBlank
    private String accessToken;

    @NotBlank
    private String refreshToken;

}
