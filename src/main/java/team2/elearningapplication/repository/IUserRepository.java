package team2.elearningapplication.repository;

import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
<<<<<<< HEAD

=======
import team2.elearningapplication.security.Role;

import java.util.List;
>>>>>>> main
=======
import team2.elearningapplication.security.Role;

import java.util.List;
>>>>>>> main
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndStatus(String username, EnumUserStatus status);
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> main

    Role findRolesByUsername(String username);

    Optional<User> findUserByEmail(String email);
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
}
