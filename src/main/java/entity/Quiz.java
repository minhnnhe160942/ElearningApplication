

package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

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
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lession;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "quiz")
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(int id, Lesson lession, String name, List<Question> questionList) {
        this.id = id;
        this.lession = lession;
        this.name = name;
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", lession=" + lession +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}