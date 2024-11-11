package com.hospital.hospitalmanagementsystem.mapper;

import com.hospital.hospitalmanagementsystem.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jdk.jfr.Registered;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {

}
