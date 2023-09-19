package team2.elearningapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.elearningapplication.dto.request.CreateUserRequestDTO;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.repository.IUserRepository;
import team2.elearningapplication.service.IUserService;
import team2.elearningapplication.typesEnum.EnumTypeRole;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO) {
        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(requestDTO.getPassword());
        user.setEmail(requestDTO.getEmail());
        user.setPhone(requestDTO.getPhone());
        user.setRole(requestDTO.getRole());
        user.setFullName(requestDTO.getFullName());
        user.setGender(requestDTO.getGender());
        user.setDate_of_birth(requestDTO.getDateOfBirth());

        User createdUser = userRepository.save(user);

        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
        responseDTO.setId(createdUser.getId());
        responseDTO.setUsername(createdUser.getUsername());
        responseDTO.setEmail(createdUser.getEmail());
        responseDTO.setCreatedAt(createdUser.getCreatedAt());

        return responseDTO;
    }

    @Override
    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setRole(user.getRole());
            updatedUser.setCreatedAt(user.getCreatedAt());
            updatedUser.setFullName(user.getFullName());
            updatedUser.setGender(user.getGender());
            updatedUser.setDate_of_birth(user.getDate_of_birth());

            return userRepository.save(updatedUser);
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
