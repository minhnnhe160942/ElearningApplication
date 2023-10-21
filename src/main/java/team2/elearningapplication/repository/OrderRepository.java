package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
