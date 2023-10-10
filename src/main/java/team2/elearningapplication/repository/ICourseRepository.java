package team2.elearningapplication.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Category;
import team2.elearningapplication.entity.Course;


import java.util.List;
import java.util.Optional;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
