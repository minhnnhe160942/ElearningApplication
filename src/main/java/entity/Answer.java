package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="answer")
@Accessors(chain=true)
@Setter
@Getter

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="answer_content")
    private String answerContent;
    @Column(name="question_id")
    private int questionId;
}