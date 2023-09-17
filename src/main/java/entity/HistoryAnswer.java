package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "history_answer")
@Accessors(chain = true)
@Setter
@Getter
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
    @Column(name = "correct")
    private int correct;

    public HistoryAnswer() {
    }

    public HistoryAnswer(int id, User user, int questionId, int userAnswerId, int correct) {
        this.id = id;
        this.user = user;
        this.questionId = questionId;
        this.userAnswerId = userAnswerId;
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "HistoryAnswer{" +
                "id=" + id +
                ", user=" + user +
                ", questionId=" + questionId +
                ", userAnswerId=" + userAnswerId +
                ", correct=" + correct +
                '}';
    }
}
