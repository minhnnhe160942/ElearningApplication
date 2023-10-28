package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment,Integer> {

}
