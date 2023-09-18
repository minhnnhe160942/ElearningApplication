package team2.elearningapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import team2.elearningapplication.typesEnum.EnumTypeGender;
import team2.elearningapplication.typesEnum.EnumTypeRole;


import java.sql.Date;
import java.time.ZonedDateTime;

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
    private ZonedDateTime createdAt;
    @Column(name = "full_name")
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private EnumTypeGender gender;
    @Column(name = "date_of_birth")
    private Date date_of_birth;

    public User() {
    }

    public User(int id, String username, String password, String email, String phone, EnumTypeRole role, ZonedDateTime createdAt, String fullName, EnumTypeGender gender, Date date_of_birth) {

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
