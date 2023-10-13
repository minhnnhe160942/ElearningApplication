package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Question;

public interface IQuestionRepository extends JpaRepository<Question,Integer> {
}
