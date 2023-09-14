package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="history_answer")
@Accessors(chain=true)
@Setter
@Getter
public class HistoryAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name="question_id")
    private int questionId;
    @Column(name="user_answer_id")
    private int userAnswerId;
    @Column(name="correct")
    private int correct;
}
