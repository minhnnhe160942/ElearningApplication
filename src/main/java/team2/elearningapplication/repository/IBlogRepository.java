package team2.elearningapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team2.elearningapplication.entity.Blog;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT b FROM Blog b WHERE b.deleted = :deleted")
    List<Blog> findBlogByDeleted(@Param("deleted") boolean deleted);
}
