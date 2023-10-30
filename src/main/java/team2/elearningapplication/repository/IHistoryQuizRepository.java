package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.HistoryQuiz;

public interface IHistoryQuizRepository extends JpaRepository<HistoryQuiz, Integer> {
}
