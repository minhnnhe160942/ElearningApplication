package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Entity
@Table(name="course")
@Accessors(chain=true)
@Setter
@Getter
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="category_id")
    private int categoryId;
    @Column(name="created_at")
    private Timestamp createdAt;
}
