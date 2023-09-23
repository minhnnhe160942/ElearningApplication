package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.CreateUserRequest;
import team2.elearningapplication.dto.request.GetOTPRequest;
import team2.elearningapplication.dto.request.LoginRequest;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.GetOTPResponse;
import team2.elearningapplication.dto.response.LoginResponse;
import team2.elearningapplication.entity.User;

import java.util.List;

public interface IUserService {
    ResponseCommon<CreateUserResponseDTO> createUser(CreateUserRequest requestDTO);

    User updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void deleteUser(int id);

    ResponseCommon<GetOTPResponse> getOtp(GetOTPRequest request);

    ResponseCommon<LoginResponse> login(LoginRequest loginRequest);
}
