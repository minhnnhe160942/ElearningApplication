package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
