package team2.elearningapplication.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.CreateUserRequest;
import team2.elearningapplication.dto.request.GetOTPRequest;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.GetOTPResponse;
import team2.elearningapplication.service.IUserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private IUserService userService;

    @PostMapping("/addusers")
    public ResponseEntity<ResponseCommon<CreateUserResponseDTO>> createUser(@Valid @RequestBody CreateUserRequest requestDTO) {
        ResponseCommon<CreateUserResponseDTO> responseDTO = userService.createUser(requestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.badRequest().build();
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

}
