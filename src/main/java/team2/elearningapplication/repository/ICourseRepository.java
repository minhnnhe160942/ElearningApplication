package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Course;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findCourseByName(String courseName);

    Optional<Course> findCourseById(int id);

    List<Course> findAllByIsDeleted(boolean isDeleted);

}
