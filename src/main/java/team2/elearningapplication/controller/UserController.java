package team2.elearningapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.CreateUserRequest;
import team2.elearningapplication.dto.request.GetOTPRequest;
import team2.elearningapplication.dto.request.LoginRequest;
import team2.elearningapplication.dto.request.VerifyOtpRequest;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.GetOTPResponse;
import team2.elearningapplication.dto.response.LoginResponse;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.service.IUserService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private IUserService userService;

    //    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @PostMapping("/register")
    public ResponseEntity<ResponseCommon<CreateUserResponseDTO>> createUser(@Valid @RequestBody CreateUserRequest requestDTO) {
        ResponseCommon<CreateUserResponseDTO> responseDTO = userService.createUser(requestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<ResponseCommon<LoginResponse>> createUser(@Valid @RequestBody LoginRequest loginRequest) {
//        ResponseCommon<LoginResponse> responseDTO = userService.login(loginRequest);
//        if (responseDTO != null) {
//            userService.login(loginRequest);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody @Valid VerifyOtpRequest request) {
        User user = userService.getUserById(request.getUserId());
        LocalDateTime localDateTime = LocalDateTime.now();
        if (request.getOtp().equals(user.getOtp()) && localDateTime.isBefore(user.getExpiredOTP())) {
            user.setStatus(EnumUserStatus.ACTIVE);
            userService.updateUser(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/getOTP")
    public ResponseEntity<ResponseCommon<GetOTPResponse>> getOTP(@Valid @RequestBody GetOTPRequest request) {
        ResponseCommon<GetOTPResponse> responseDTO = userService.getOtp(request);
        // if responseDTO not null -> return responseDTO
        if (responseDTO != null) return ResponseEntity.ok(responseDTO);
            // else -> return badrequest
        else return ResponseEntity.badRequest().build();
    }

}
