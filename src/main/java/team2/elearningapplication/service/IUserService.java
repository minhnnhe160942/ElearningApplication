package team2.elearningapplication.service;

import team2.elearningapplication.dto.request.CreateUserRequestDTO;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.entity.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface IUserService {
    CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO);

    User updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void deleteUser(int id);
}
