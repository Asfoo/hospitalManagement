package com.hospital.hospitalmanagementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Users;
import com.hospital.hospitalmanagementsystem.mapper.UsersMapper;
import com.hospital.hospitalmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<UsersMapper, Users> implements AdminService {

    @Autowired
    private UsersMapper userMapper;

    @Override
    public ResultMessage createUser(Users user) {
        int result = userMapper.insert(user);
        return result > 0 ? ResultMessage.success("User created successfully") : ResultMessage.error("User creation failed");
    }

    @Override
    public ResultMessage updateUser(Long userId, Users user) {
        user.setUserId(userId);
        int result = userMapper.updateById(user);
        return result > 0 ? ResultMessage.success("User updated successfully") : ResultMessage.error("User update failed");
    }

    @Override
    public ResultMessage deleteUser(Long userId) {
        int result = userMapper.deleteById(userId);
        return result > 0 ? ResultMessage.success("User deleted successfully") : ResultMessage.error("User deletion failed");
    }

    @Override
    public ResultMessage viewAllUsers() {
        List<Users> users = userMapper.selectList(null);
        return ResultMessage.success("Users fetched successfully", users);
    }
}
