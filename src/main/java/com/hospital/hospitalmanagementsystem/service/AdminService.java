package com.hospital.hospitalmanagementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Users;

public interface AdminService extends IService<Users> {
    ResultMessage createUser(Users user);
    ResultMessage updateUser(long userId, Users user);
    ResultMessage deleteUser(long userId);
    ResultMessage viewAllUsers();
}

