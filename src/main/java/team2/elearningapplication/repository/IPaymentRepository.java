package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.Payment;
import team2.elearningapplication.entity.User;

import java.util.List;

public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findPaymentByUser(User user);

    @Query("SELECT p FROM Payment p WHERE YEAR(p.created_at) = :year")
    List<Payment> findByYear(@Param("year") Integer year);

    @Query("SELECT p FROM Payment p WHERE MONTH(p.created_at) = :month AND YEAR(p.created_at) = :year")
    List<Payment> findByMonthAndYear(@Param("month") Integer month, @Param("year") Integer year);

    @Query("SELECT p FROM Payment p WHERE " +
            "(:month IS NULL OR (MONTH(p.created_at) = :month AND YEAR(p.created_at) = :year)) " +
            "AND (:courseId IS NULL OR p.course.id = :courseId)")
    List<Payment> findByCourseIdAndMonthAndYear(
            @Param("courseId") int courseId,
            @Param("month") Integer month,
            @Param("year") Integer year);

    @Query("SELECT p FROM Payment p WHERE " +
            "(:courseId IS NULL OR p.course.id = :courseId) " +
            "AND (:year IS NULL OR YEAR(p.created_at) = :year)")
    List<Payment> findByCourseIdAndYear(
            @Param("courseId") int courseId,
            @Param("year") Integer year);
}
