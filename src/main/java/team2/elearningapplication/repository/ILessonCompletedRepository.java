package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Lesson;
import team2.elearningapplication.entity.LessonCompleted;
import team2.elearningapplication.entity.User;

import java.util.Optional;

public interface ILessonCompletedRepository extends JpaRepository<LessonCompleted,Integer> {

    Optional<LessonCompleted> findLessonsByUserAndLesson(User user, Lesson lesson);
}
