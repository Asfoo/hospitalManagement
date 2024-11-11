package com.hospital.hospitalmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hospital.hospitalmanagementsystem.dto.UserRegistrationDto;
import com.hospital.hospitalmanagementsystem.entity.Users;
import com.hospital.hospitalmanagementsystem.mapper.UsersMapper;
import com.hospital.hospitalmanagementsystem.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper userMapper;

    /**
     * Registers a new user if they do not already exist.
     *
     * @param userDto Data transfer object containing user registration details.
     * @return A success message if the user is registered successfully; otherwise, an error message.
     */
    @Override
    public String registerUser(UserRegistrationDto userDto) {
        // Check if a user with the same email or phone number already exists
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(Users::getEmail, userDto.getEmail())
                .or()
                .eq(Users::getPhone, userDto.getPhone());

        Users existingUser = userMapper.selectOne(queryWrapper);

        if (!ObjectUtils.isEmpty(existingUser)) {
            return "User with this email or phone number already exists.";
        }

        // Create a new user entity
        Users newUser = new Users();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());  // Ideally, hash the password before storing
        newUser.setRole(userDto.getRole());
        newUser.setPhone(userDto.getPhone());

        // Insert the new user into the database
        int result = userMapper.insert(newUser);

        return result > 0 ? "User registered successfully." : "Registration failed, please try again.";
    }
}
