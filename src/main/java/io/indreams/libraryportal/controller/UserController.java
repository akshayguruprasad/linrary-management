package io.indreams.libraryportal.controller;

import io.indreams.libraryportal.model.UserDTO;
import io.indreams.libraryportal.model.UserEntity;
import io.indreams.libraryportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userName}")
    public UserEntity getUser(String userName) {
        return userService.getUser(userName);
    }
    @GetMapping("/users")
    public List<UserEntity> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public void addUser(UserDTO userDTO) {
        userService.addUser(userDTO);
    }

}
