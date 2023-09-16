

package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Entity
@Table(name = "quiz")
@Accessors(chain = true)
@Setter
@Getter

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "lesson")
    private Lesson lessionId;
    @Column(name = "name")
    private String name;
}