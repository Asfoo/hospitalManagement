package com.hospital.hospitalmanagementsystem.service;

import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.dto.UserLoginDto;
import com.hospital.hospitalmanagementsystem.dto.UserRegistrationDto;
import com.hospital.hospitalmanagementsystem.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
public interface IUsersService extends IService<Users> {
    String registerUser(UserRegistrationDto userDto);
    public ResultMessage loginUser(UserLoginDto loginDto);
}
