package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface IAnswerRepository extends JpaRepository<Answer,Integer> {
    Optional<Answer> findAnswerById(int answerID);

    Optional<Answer> findAnswerByQuestionIdAndId(int questionID, int answerID);

    List<Answer> findAnswerByQuestionId(int questionID);

    @Query(value = "SELECT * FROM Answer WHERE question_id = :preQuestionId AND is_correct = true", nativeQuery = true)
    Answer findCorrectAnswer(@Param("preQuestionId") int preQuestionId);

}
