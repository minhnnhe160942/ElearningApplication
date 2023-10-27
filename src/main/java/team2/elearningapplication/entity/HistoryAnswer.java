package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "history_answer")
@Accessors(chain = true)
@Data
public class HistoryAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "user_answer_id")
    private int userAnswerId;
    @Column(name = "answer_id_correct")
    private boolean answerIdCorrect;
    @Column(name="sessionId")
    private int sessionId;

}
