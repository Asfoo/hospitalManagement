package com.hospital.hospitalmanagementsystem.controller;

import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Users;
import com.hospital.hospitalmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 1. Create a new user
    @PostMapping("/create-user")
    public ResultMessage createUser(@RequestBody Users user) {
        return adminService.createUser(user);
    }

    // 2. Update an existing user
    @PutMapping("/update-user/{userId}")
    public ResultMessage updateUser(@PathVariable Long userId, @RequestBody Users user) {
        return adminService.updateUser(userId, user);
    }

    // 3. Delete an existing user
    @DeleteMapping("/delete-user/{userId}")
    public ResultMessage deleteUser(@PathVariable Long userId) {
        return adminService.deleteUser(userId);
    }

    // 4. View all users (optional - for admin overview)
    @GetMapping("/view-users")
    public ResultMessage viewAllUsers() {
        return adminService.viewAllUsers();
    }
}

