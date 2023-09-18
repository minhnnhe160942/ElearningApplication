package team2.elearningapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Entity
@Table(name = "lesson")
@Accessors(chain = true)
@Setter
@Getter

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "stt")
    private int ordNumber;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
    @Column(name = "link_content")
    private String linkContent;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    public Lesson() {
    }

    public Lesson(int id, int ordNumber, Course course, String linkContent, String description, ZonedDateTime createdAt) {
        this.id = id;
        this.ordNumber = ordNumber;
        this.course = course;
        this.linkContent = linkContent;
        this.description = description;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", ordNumber=" + ordNumber +
                ", course=" + course +
                ", linkContent='" + linkContent + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
