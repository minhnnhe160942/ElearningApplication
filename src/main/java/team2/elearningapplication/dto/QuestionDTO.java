package team2.elearningapplication.dto;

public class QuestionDTO {
    private Integer id;
    private String question;
    private Integer correctAnswerId;
    private Integer quizId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getCorrectAnswerId() {
        return this.correctAnswerId;
    }

    public void setCorrectAnswerId(Integer correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public Integer getQuizId() {
        return this.quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
}
