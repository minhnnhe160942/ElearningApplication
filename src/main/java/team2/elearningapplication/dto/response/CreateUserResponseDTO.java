package team2.elearningapplication.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserResponseDTO {
    private int id;
    private String username;
    private String email;
    private LocalDate createdAt;

    public CreateUserResponseDTO(int id, String username, String email, LocalDate createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }

    public CreateUserResponseDTO() {
        
    }
}
