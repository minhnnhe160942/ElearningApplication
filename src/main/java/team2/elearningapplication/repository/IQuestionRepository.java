package team2.elearningapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Question;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAll();
   // List<Question> findBySubjectAndLessonAndDimensionAndLevelAndStatus(String subject, String lesson, String dimension, String level, String status);
}
