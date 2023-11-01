package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team2.elearningapplication.entity.Blog;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
