package team2.elearningapplication.dto.response;

<<<<<<< HEAD
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
=======
=======
>>>>>>> main
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
public class CreateUserResponseDTO {
    private int id;
    private String username;
    private String email;
<<<<<<< HEAD
<<<<<<< HEAD
    private LocalDate createdAt;

    public CreateUserResponseDTO(int id, String username, String email, LocalDate createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }

    public CreateUserResponseDTO() {
        
    }
=======
    private LocalDateTime createdAt;
>>>>>>> main
=======
    private LocalDateTime createdAt;
>>>>>>> main
}
