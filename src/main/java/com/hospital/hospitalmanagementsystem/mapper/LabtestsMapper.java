package com.hospital.hospitalmanagementsystem.mapper;

import com.hospital.hospitalmanagementsystem.entity.Labtests;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface LabtestsMapper extends BaseMapper<Labtests> {

}
