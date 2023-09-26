package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
<<<<<<< HEAD
<<<<<<< HEAD
import team2.elearningapplication.dto.request.CreateUserRequest;
import team2.elearningapplication.dto.request.GetOTPRequest;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.GetOTPResponse;
import team2.elearningapplication.entity.User;
=======
=======
>>>>>>> main
import team2.elearningapplication.dto.request.*;
import team2.elearningapplication.dto.response.*;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.security.jwt.JWTResponse;
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main

import java.util.List;

public interface IUserService {
    ResponseCommon<CreateUserResponseDTO> createUser(CreateUserRequest requestDTO);

    User updateUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void deleteUser(int id);

    ResponseCommon<GetOTPResponse> getOtp(GetOTPRequest request);
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> main

    ResponseCommon<JWTResponse> login(LoginRequest loginRequest);

    ResponseCommon<VerifyOtpResponse> verifyOtp(VerifyOtpRequest verifyOtpRequest);

    ResponseCommon<ForgotPasswordResponse> forgotPassword(ForgotPasswordRequest forgotPasswordRequest);

    ResponseCommon<ChangePasswordResponse> changePassword(ChangePasswordRequest changePasswordRequest);
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
}
