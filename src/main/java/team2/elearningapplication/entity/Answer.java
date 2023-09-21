package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "answer")
@Accessors(chain = true)
@Setter
@Getter

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "answer_content")
    private String answerContent;
    @Column(name = "question_id")
    private int questionId;

    public Answer() {
    }

    public Answer(int id, String answerContent, int questionId) {
        this.id = id;
        this.answerContent = answerContent;
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerContent='" + answerContent + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}