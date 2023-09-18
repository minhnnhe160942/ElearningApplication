package team2.elearningapplication.dto;

public class HistoryAnswerDTO {
    private Integer id;
    private Integer userId;
    private Integer questionId;
    private Integer userAnswerId;
    private Byte correct;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserAnswerId() {
        return this.userAnswerId;
    }

    public void setUserAnswerId(Integer userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    public Byte getCorrect() {
        return this.correct;
    }

    public void setCorrect(Byte correct) {
        this.correct = correct;
    }
}
