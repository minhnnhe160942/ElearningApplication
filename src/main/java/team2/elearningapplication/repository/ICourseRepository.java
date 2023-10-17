package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.Course;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findCourseByName(String courseName);

    Optional<Course> findCourseById(int id);

    List<Course> findAllByIsDeleted(boolean isDeleted);

    @Query(value = "SELECT c.id, c.name, c.description, c.category_id, c.created_at, c.price, c.link_thumnail " +
            "FROM course c " +
            "JOIN history_register_course hrc ON c.id = hrc.course_id " +
            "GROUP BY c.id " +
            "ORDER BY COUNT(hrc.user_id) DESC " +
            "LIMIT :number", nativeQuery = true)
    List<Course> getTopCourses(@Param("number") int number);
    @Query(value = "SELECT * FROM Course ORDER BY created_at DESC LIMIT :number", nativeQuery = true)
    List<Course> getTopNewCourse(@Param("number") int number);

    @Query(value = "SELECT c.* FROM Course c " +
            "INNER JOIN history_register_course hrc ON c.id = hrc.course_id " +
            "WHERE hrc.user_id = :userId", nativeQuery = true)
    List<Course> getCoursesByUserId(@Param("userId") int userId);

}
