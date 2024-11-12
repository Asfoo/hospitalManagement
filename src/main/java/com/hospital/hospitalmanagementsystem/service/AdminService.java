package com.hospital.hospitalmanagementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface AdminService extends IService<Users> {
    ResultMessage createUser(Users user);
    ResultMessage updateUser(Long userId, Users user);
    ResultMessage deleteUser(Long userId);
    ResultMessage viewAllUsers();
}

