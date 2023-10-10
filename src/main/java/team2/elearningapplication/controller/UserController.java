package team2.elearningapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.*;
import team2.elearningapplication.dto.response.*;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.security.UserDetailsImpl;
import team2.elearningapplication.security.jwt.JWTResponse;
import team2.elearningapplication.security.jwt.JWTUtils;
import team2.elearningapplication.service.IUserService;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Log4j2
public class UserController {

    private IUserService userService;
    private final JWTUtils jwtUtils;

    //    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @PostMapping("/register")
    public ResponseEntity<ResponseCommon<CreateUserResponseDTO>> createUser(@Valid @RequestBody CreateUserRequest requestDTO) {
        log.debug("Handle request create user with email{}",requestDTO.getEmail());
        ResponseCommon<CreateUserResponseDTO> responseDTO = userService.createUser(requestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/verify-otp")
    public ResponseEntity<ResponseCommon<VerifyOtpResponse>> verifyOtp(@Valid @RequestBody  VerifyOtpRequest request) {
        log.debug("Handle verify otp with id{}", request.getEmail());
        User user = userService.getUserByUsername(userService.genUserFromEmail(request.getEmail()));

        ResponseCommon<VerifyOtpResponse> response = userService.verifyOtp(request);
        // if response code == 0 -> return success
        if(response.getCode()==0){
            user.setStatus(EnumUserStatus.ACTIVE);
            userService.updateUser(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/getOTP")
    public ResponseEntity<ResponseCommon<GetOTPResponse>> getOTP(@Valid @RequestBody GetOTPRequest request) {
        ResponseCommon<GetOTPResponse> responseDTO = userService.getOtp(request);
        // if responseDTO not null -> return responseDTO
        if (responseDTO != null) return ResponseEntity.ok(responseDTO);
            // else -> return badrequest
        else return ResponseEntity.badRequest().build();
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseCommon<JWTResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            ResponseCommon<JWTResponse> response = userService.login(loginRequest);

            if (response.getCode() == 0) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/send-otp-forgot-password")
    public ResponseEntity<ResponseCommon<ForgotPasswordResponse>> sendOTPForgotPass(@Valid @RequestBody SendOTPForgotPasswordRequest sendOTPForgotPasswordRequest) {
        User user = userService.getUserByUsername(userService.genUserFromEmail(sendOTPForgotPasswordRequest.getEmail()));
        // if user is null -> tell error
        if (Objects.isNull(user))
            return new ResponseEntity<>(new ResponseCommon<>(ResponseCode.USER_NOT_FOUND, null), HttpStatus.BAD_REQUEST);
        else {
            GetOTPRequest request = new GetOTPRequest(sendOTPForgotPasswordRequest.getEmail(), false);
            userService.getOtp(request);
            return new ResponseEntity<>(new ResponseCommon<>(ResponseCode.SUCCESS, null), HttpStatus.OK);
        }
    }

    @PostMapping("/verify-otp-forgotPass")
    public ResponseEntity<ResponseCommon<VerifyOtpResponse>> verifyOtpForgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {

        User user = userService.getUserByUsername(userService.genUserFromEmail(forgotPasswordRequest.getEmail()));
        // if user is null -> tell error
        if(Objects.isNull(user)){
            return new ResponseEntity<>(new ResponseCommon<>(ResponseCode.USER_NOT_FOUND,null),HttpStatus.BAD_REQUEST);
        }
        VerifyOtpRequest request = new VerifyOtpRequest(forgotPasswordRequest.getOtp(), user.getEmail());
        ResponseCommon<VerifyOtpResponse> response = userService.verifyOtp(request);
        // if response code == 0 -> return success
        if(response.getCode()==0){
            user.setPassword(forgotPasswordRequest.getPassword());
            userService.updateUser(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(
        security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping("/changePassword")
    public ResponseEntity<ResponseCommon<ChangePasswordResponse>> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest){
        ResponseCommon<ChangePasswordResponse> response = userService.changePassword(changePasswordRequest);
        // if response equals success -> return response
        if(response.getCode() == 0){
            return ResponseEntity.ok(response);
        } else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/refresh-access-token")
    public ResponseEntity<JWTResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();
        User user = userService.getUserByUsername(userService.genUserFromEmail(request.getEmail()));
        UserDetailsImpl userDetails =  UserDetailsImpl.build(user);
        String accessToken = jwtUtils.generateAccessToken(userDetails);
        JWTResponse response = new JWTResponse();
        response.setAccessToken(accessToken);
        return ResponseEntity.ok(response);
    }


}
