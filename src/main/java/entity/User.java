package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;



import java.sql.Timestamp;

@Entity
@Table(name="users")
@Accessors(chain=true)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private EnumTypeRole role;
    @Column(name="created_at")
    private Timestamp createdAt;
}
