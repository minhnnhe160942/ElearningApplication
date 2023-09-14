package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="question")
@Accessors(chain=true)
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="question")
    private String question;
    @Column(name="correct_answer_id")
    private int correctAnswerId;
    @Column(name="quiz_id")
    private int quiz_id;
}
