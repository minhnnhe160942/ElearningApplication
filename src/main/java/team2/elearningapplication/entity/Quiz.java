

package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    @JoinColumn
    private Lesson lesson;
    @Column(name = "name")
    private String name;
    @OneToMany
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(int id, Lesson lesson, String name, List<Question> questionList) {
        this.id = id;
        this.lesson = lesson;
        this.name = name;
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", lesson=" + lesson +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}