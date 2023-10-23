package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.user.GetUserByEmailRequest;
import team2.elearningapplication.dto.request.user.*;
import team2.elearningapplication.dto.response.admin.dashboard.GetTotalUserResponse;
import team2.elearningapplication.dto.response.user.*;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.security.jwt.JWTResponse;

import java.util.List;

public interface IUserService {

    ResponseCommon<>
    ResponseCommon<CreateUserResponseDTO> createUser(CreateUserRequest requestDTO);

    User updateUser(User user);

    ResponseCommon<GetOTPResponse> getOtp(GetOTPRequest request);

    ResponseCommon<JWTResponse> login(LoginRequest loginRequest);

    ResponseCommon<VerifyOtpResponse> verifyOtp(VerifyOtpRequest verifyOtpRequest);

    ResponseCommon<ChangePasswordResponse> changePassword(ChangePasswordRequest changePasswordRequest);

    String genUserFromEmail(String email);

    User getUserByUsername(String username);

    ResponseCommon<ChangeProfileResponse> changeProfile(ChangeProfileRequest changeProfileRequest);

    ResponseCommon<GetUserByEmailResponse> getUserByEmail(GetUserByEmailRequest getUserByEmailRequest);

    ResponseCommon<LogOutResponse> logOut(LogOutRequest logOutRequest);

    ResponseCommon<GetTotalUserResponse> getTotalUser();

    ResponseCommon<ResendOTPResponse> resendOTP(ResendOTPRequest request);
}
