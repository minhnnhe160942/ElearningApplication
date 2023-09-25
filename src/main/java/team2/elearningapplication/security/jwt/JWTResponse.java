package team2.elearningapplication.security.jwt;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

public class JWTResponse {
    private Map<String, String> token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private List<String> roles;

    public JWTResponse(Map<String, String> token, Long id, String username, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public Map<String, String> getToken() {
        return token;
    }

    public void setToken(Map<String, String> token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTResponse {
    private String accessToken;
    private String refreshToken;
    private String message;
>>>>>>> main
}
