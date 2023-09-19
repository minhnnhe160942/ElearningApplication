package team2.elearningapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.dto.request.CreateUserRequestDTO;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.service.IUserService;
import team2.elearningapplication.typesEnum.EnumTypeGender;
import team2.elearningapplication.typesEnum.EnumTypeRole;

@RestController
@RequestMapping("/api")
public class UserController {
    private IUserService userService;

    @PostMapping("/addusers")
    public ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO requestDTO) {
        CreateUserResponseDTO responseDTO = userService.createUser(requestDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
