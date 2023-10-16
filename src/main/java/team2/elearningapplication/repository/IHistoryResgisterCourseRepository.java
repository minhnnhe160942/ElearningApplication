package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.HistoryRegisterCourse;

public interface IHistoryResgisterCourseRepository extends JpaRepository<HistoryRegisterCourse,Integer> {
}
