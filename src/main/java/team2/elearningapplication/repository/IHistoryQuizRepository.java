package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.HistoryQuiz;
import team2.elearningapplication.entity.Quiz;
import team2.elearningapplication.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface IHistoryQuizRepository extends JpaRepository<HistoryQuiz, Integer> {
    @Query("SELECT DISTINCT hq.sessionId FROM HistoryQuiz hq WHERE hq.user = :user AND hq.quiz = :quiz")
    List<Integer> findDistinctSessionIdsByUserAndQuiz(@Param("user") User user, @Param("quiz") Quiz quiz);


    @Query("SELECT COUNT(hq) FROM HistoryQuiz hq WHERE hq.sessionId = :sessionId AND hq.isCorrect = FALSE")
    int countIncorrectAnswersBySessionId(@Param("sessionId") int sessionId);

    @Query("SELECT COUNT(hq) FROM HistoryQuiz hq WHERE hq.sessionId = :sessionId AND hq.isCorrect = TRUE")
    int countCorrectAnswersBySessionId(@Param("sessionId") int sessionId);

    @Query("SELECT MAX(hq.createdAt) FROM HistoryQuiz hq WHERE hq.sessionId = :sessionId")
    LocalDateTime findLatestCreatedAtBySessionId(@Param("sessionId") int sessionId);

    @Query("SELECT hq.answerId FROM HistoryQuiz hq WHERE hq.sessionId = :sessionId AND hq.isCorrect = TRUE")
    List<Integer> findAnswerIdsBySessionIdAndCorrect(@Param("sessionId") int sessionId);

    @Query("SELECT hq.answerId FROM HistoryQuiz hq WHERE hq.sessionId = :sessionId AND hq.isCorrect = FALSE")
    List<Integer> findAnswerIdsBySessionIdAndInCorrect(@Param("sessionId") int sessionId);
}
