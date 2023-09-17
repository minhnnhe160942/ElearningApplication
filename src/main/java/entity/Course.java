package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "course")
@Accessors(chain = true)
@Setter
@Getter
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @Column(name = "created_at")
    private ZonedDateTime createdAt;
    @Column(name = "link_thumnail")
    private String linkThumnail;

    public Course() {
    }

    public Course(int id, String name, String description, Category category, ZonedDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", createdAt=" + createdAt +
                '}';
    }
}
