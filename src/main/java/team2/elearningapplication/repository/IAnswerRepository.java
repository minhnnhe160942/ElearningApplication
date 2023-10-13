package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface IAnswerRepository extends JpaRepository<Answer,Integer> {
    Optional<Answer> findAnswerById(int answerID);

    Optional<Answer> findAnswerByQuestionIdAndId(int questionID, int answerID);

    List<Answer> findAnswerByQuestionId(int questionID);
}
