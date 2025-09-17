package com.ftms.Controller;

import com.ftms.DTO.UserRequestDTO;
import com.ftms.DTO.UserResponseDTO;
import com.ftms.Service.UserService;
import com.ftms.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Post user in DB
    @PostMapping()
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    // Fetch all user from DB
    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.fetchAllUser());
    }

}
