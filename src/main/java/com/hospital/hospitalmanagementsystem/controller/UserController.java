package com.hospital.hospitalmanagementsystem.controller;

import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.dto.UserRegistrationDto;
import com.hospital.hospitalmanagementsystem.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUsersService userService;

    /**
     * Endpoint for user registration.
     *
     * @param userDto Data transfer object containing user registration details.
     * @return ResponseEntity with success or error message.
     */
    @PostMapping("/register")
    public ResultMessage registerUser(@RequestBody UserRegistrationDto userDto) {
        String result = userService.registerUser(userDto);

        if ("User registered successfully.".equals(result)) {
            return ResultMessage.success("User registered successfully.");
        } else {
            return ResultMessage.error(400, result);
        }
    }
}
