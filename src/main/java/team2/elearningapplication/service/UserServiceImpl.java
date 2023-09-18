package team2.elearningapplication.service;

import team2.elearningapplication.entity.User;
import team2.elearningapplication.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.elearningapplication.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        // if user differnce null -> add user to database
        if (user != null) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUser(int id, User user) throws UserNotFoundException {
        // if user not null -> get user to update
        if (user != null) {
            User userUpdate = userRepository.findById(id).orElse(null);
            // if userUpdate not null -> update user
            if (userUpdate != null) {
                userUpdate.setUsername(user.getUsername());
                userUpdate.setPassword(user.getPassword());
                userUpdate.setEmail(user.getEmail());
                userUpdate.setPhone(user.getPhone());
                userUpdate.setRole(user.getRole());
                userUpdate.setCreatedAt(user.getCreatedAt());
                userUpdate.setFullName(user.getFullName());
                userUpdate.setGender(user.getGender());
                userUpdate.setDate_of_birth(user.getDate_of_birth());

                userRepository.save(userUpdate);
                return userUpdate;
            } else {
                // Throw an exception if user not found
                throw new UserNotFoundException("User with ID: " + id + " not found");
            }
        } else {
            // Throw an exception if user is null
            throw new UserNotFoundException("User is null");
        }
    }


    @Override
    public boolean deleteUser(int id) {
        // if id >= 1 -> find User by id to delete
        if (id >= 1) {
            User userDelete = userRepository.findById(id).orElse(null);
            // if user not null -> delete user
            if (userDelete != null) {
                userRepository.delete(userDelete);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
