package team2.elearningapplication.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.HistoryAnswer;

public interface HistoryAnswerRepository extends JpaRepository<HistoryAnswer,Integer> {
}
