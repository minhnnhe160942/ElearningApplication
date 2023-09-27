package team2.elearningapplication.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.entity.Lesson;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Integer> {
    <S extends Lesson> List<S> findAll(Course course);
}
