package com.hospital.hospitalmanagementsystem.mapper;

import com.hospital.hospitalmanagementsystem.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author asfand
 * @since 2024-11-12
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {
    @Mapper
    public interface UserMapper extends BaseMapper<Users> {

        // Retrieve all doctors
        @Select("SELECT * FROM Users WHERE role = 'Doctor'")
        List<Users> selectDoctors();
    }

}
