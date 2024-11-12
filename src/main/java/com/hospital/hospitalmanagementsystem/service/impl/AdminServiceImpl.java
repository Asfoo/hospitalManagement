package com.hospital.hospitalmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Users;
import com.hospital.hospitalmanagementsystem.mapper.UsersMapper;
import com.hospital.hospitalmanagementsystem.service.AdminService;
import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl extends ServiceImpl<UsersMapper, Users> implements AdminService {

    @Autowired
    private UsersMapper userMapper;

    // 1. Create a new user
    @Override
    public ResultMessage createUser(Users user) {
        int result = userMapper.insert(user);
        return result > 0 ? ResultMessage.success("User created successfully") : ResultMessage.error("User creation failed");
    }

    // 2. Update an existing user
    @Override
    public ResultMessage updateUser(long userId, Users user) {
        user.setUserId((int) userId); // Ensure the correct user is updated
        int result = userMapper.updateById(user);
        return result > 0 ? ResultMessage.success("User updated successfully") : ResultMessage.error("User update failed");
    }

    // 3. Delete a user by ID
    @Override
    public ResultMessage deleteUser(long userId) {
        int result = userMapper.deleteById(userId);
        return result > 0 ? ResultMessage.success("User deleted successfully") : ResultMessage.error("User deletion failed");
    }

    // 4. View all users (optional)
    @Override
    public ResultMessage viewAllUsers() {
        List<Users> users = userMapper.selectList(null);
        return ResultMessage.success("Users fetched successfully", users);
    }
}

