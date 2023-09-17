package service;

import entity.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface IUserService {

    // add user
    public User addUser(User user);

    // edit user
    public User updateUser(int id, User user) throws UserPrincipalNotFoundException;

    // delete user
    public boolean deleteUser(int id);

    // get list user
    public List<User> getAllUser();

    // get a user by id
    public User getUserByID(int id);
}
