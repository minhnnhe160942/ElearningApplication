package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

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
    @JoinColumn(name = "course_id")
    private Course courseID;
    @Column(name = "link_content")
    private String linkContent;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private Timestamp createdAt;
}
