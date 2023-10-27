package team2.elearningapplication.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.HistoryAnswer;

import java.util.List;

public interface HistoryAnswerRepository extends JpaRepository<HistoryAnswer,Integer> {
    @Query("SELECT ha FROM HistoryAnswer ha WHERE ha.sessionId = :sessionId AND ha.userAnswerId = ha.answerIdCorrect")
    List<HistoryAnswer> findMatchingAnswers(@Param("sessionId") int sessionId);

    @Query("SELECT ha FROM HistoryAnswer ha WHERE ha.sessionId = :sessionId AND ha.userAnswerId <> ha.answerIdCorrect")
    List<HistoryAnswer> findNonMatchingAnswers(@Param("sessionId") int sessionId);

}
