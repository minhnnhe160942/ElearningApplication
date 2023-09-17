package controller;

import entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1.0/Users")
public class UserController {
    @GetMapping("")
    List<String> getAllUser() {
        return List.of("minh", "quang");
    }
}
