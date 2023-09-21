package team2.elearningapplication.repository;

import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndStatus(String username, EnumUserStatus status);
}
