package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "answer")
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "answer_content")
    private String answerContent;
    @Column(name="is_correct")
    private boolean isCorrect;
    @Column(name = "question_id")
    private int questionId;

}