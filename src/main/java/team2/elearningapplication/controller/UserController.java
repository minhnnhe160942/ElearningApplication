package team2.elearningapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.dto.UsersDTO;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.service.IUserService;
import team2.elearningapplication.typesEnum.EnumTypeGender;
import team2.elearningapplication.typesEnum.EnumTypeRole;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UsersDTO> addUser(@RequestBody UsersDTO requestDTO) {
        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(requestDTO.getPassword());
        user.setEmail(requestDTO.getEmail());
        user.setPhone(requestDTO.getPhone());
        user.setRole(EnumTypeRole.valueOf(requestDTO.getRole()));
        user.setCreatedAt(ZonedDateTime.now());
        user.setFullName(requestDTO.getFullName());
        user.setGender(EnumTypeGender.valueOf(requestDTO.getGender()));
        user.setDate_of_birth(requestDTO.getDateOfBirth());
        userService.addUser(requestDTO);
        return ResponseEntity.ok(requestDTO);
    }
}
