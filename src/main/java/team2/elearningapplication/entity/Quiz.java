

package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz")
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn
    private Lesson lesson;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn
    private Question question;
    @Column(name="deleted")
    private boolean isDeleted;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}