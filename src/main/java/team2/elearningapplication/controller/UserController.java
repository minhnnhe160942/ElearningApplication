package team2.elearningapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.*;
import team2.elearningapplication.dto.response.*;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.security.jwt.JWTResponse;
import team2.elearningapplication.service.IUserService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Log4j2
public class UserController {

    private IUserService userService;

    //    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @PostMapping("/register")
    public ResponseEntity<ResponseCommon<CreateUserResponseDTO>> createUser(@Valid @RequestBody CreateUserRequest requestDTO) {
        log.debug("Handle request create user with username{}",requestDTO.getUsername());
        ResponseCommon<CreateUserResponseDTO> responseDTO = userService.createUser(requestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/verify-otp")
    public ResponseEntity<ResponseCommon<VerifyOtpResponse>> verifyOtp(@Valid @RequestBody  VerifyOtpRequest request) {
        log.debug("Handle verify otp with id{}", request.getUserId());
        User user = userService.getUserById(request.getUserId());

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

    @PostMapping("/forgotPassword")
    public ResponseEntity<ResponseCommon<ForgotPasswordResponse>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest){
        log.debug("forgot password with username{}",forgotPasswordRequest.getUsername());
        ResponseCommon<ForgotPasswordResponse> response = userService.forgotPassword(forgotPasswordRequest);
        // if response equals success -> return response
        if(response.getMessage().equals("Success")){
            return ResponseEntity.ok(response);
        } else return ResponseEntity.badRequest().build();
    }
    @PostMapping("/verify-otp-forgotPass")
    public ResponseEntity<ResponseCommon<VerifyOtpResponse>> verifyOtpForgotPassword(@Valid @RequestBody  VerifyOtpRequest request) {
        log.debug("Handle verify otp forgotpassword with id{}", request.getUserId());
        User user = userService.getUserById(request.getUserId());

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

    @PostMapping("/changePassword")
    public ResponseEntity<ResponseCommon<ChangePasswordResponse>> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest){
        ResponseCommon<ChangePasswordResponse> response = userService.changePassword(changePasswordRequest);
        // if response equals success -> return response
        if(response.getMessage().equals("Success")){
            return ResponseEntity.ok(response);
        } else return ResponseEntity.badRequest().build();
    }
}