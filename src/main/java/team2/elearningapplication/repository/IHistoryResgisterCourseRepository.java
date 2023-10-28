package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.HistoryRegisterCourse;
import team2.elearningapplication.entity.User;

import java.util.Optional;

public interface IHistoryResgisterCourseRepository extends JpaRepository<HistoryRegisterCourse,Integer> {
    Optional<HistoryRegisterCourse> findHistoryRegisterCourseByCourseIdAndAndUser(int courseId, User user);
}
