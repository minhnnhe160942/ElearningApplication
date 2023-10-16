package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import team2.elearningapplication.Enum.EnumTypeGender;
import team2.elearningapplication.Enum.EnumTypeRole;
import team2.elearningapplication.Enum.EnumUserStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Accessors(chain = true)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private EnumTypeRole role;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "full_name")
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private EnumTypeGender gender;
    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
    @Column(name = "expired_otp")
    private LocalDateTime expiredOTP;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumUserStatus status;
    @Column(name = "otp")
    private String otp;

    public User() {
    }

    public User(int id, String username, String password, String email, String phone, EnumTypeRole role, LocalDateTime createdAt, String fullName, EnumTypeGender gender, LocalDate date_of_birth) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
        this.fullName = fullName;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
