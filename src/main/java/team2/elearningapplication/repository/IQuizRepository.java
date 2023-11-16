package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface IQuizRepository extends JpaRepository<Quiz,Integer> {
    Optional<Quiz> findQuizById(int id);
    Optional<Quiz> findQuizByName(String quizName);
    List<Quiz> findAllByIsDeleted(boolean isDeleted);

    Optional<Quiz> findByLesson(int lessonId);

    @Query("SELECT q FROM Quiz q WHERE q.lesson.id = :lessonId AND q.isFinalQuiz = true")
    Optional<Quiz> findFinalQuizByLessonId(@Param("lessonId") int lessonId);
}
