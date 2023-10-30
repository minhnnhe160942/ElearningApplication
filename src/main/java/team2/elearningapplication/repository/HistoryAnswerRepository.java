package team2.elearningapplication.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.HistoryAnswer;
import team2.elearningapplication.entity.User;

import java.util.List;

public interface HistoryAnswerRepository extends JpaRepository<HistoryAnswer,Integer> {
    @Query("SELECT ha FROM HistoryAnswer ha WHERE ha.sessionId = :sessionId AND ha.userAnswerId = ha.answerIdCorrect")
    List<HistoryAnswer> findMatchingAnswers(@Param("sessionId") int sessionId);


    @Query("SELECT ha FROM HistoryAnswer ha WHERE ha.sessionId = :sessionId AND ha.userAnswerId <> ha.answerIdCorrect")
    List<HistoryAnswer> findNonMatchingAnswers(@Param("sessionId") int sessionId);

    @Modifying
    @Query("DELETE FROM HistoryAnswer ha WHERE ha.sessionId = :sessionId AND ha.user = :userId")
    void deleteBySessionIdAndUser(@Param("sessionId") int sessionId, @Param("user") User user);

}
