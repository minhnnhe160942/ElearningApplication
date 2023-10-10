package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Lesson;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ILessonRespository extends JpaRepository<Lesson,Integer> {
    Optional<Lesson> findLessonById(int id);
}
