

package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Entity
@Table(name="quiz")
@Accessors(chain=true)
@Setter
@Getter

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="lesson_id")
    private int lessionId;
    @Column(name="name")
    private String name;
}