package com.hospital.hospitalmanagementsystem.service.impl;

import com.hospital.hospitalmanagementsystem.entity.Patients;
import com.hospital.hospitalmanagementsystem.mapper.PatientsMapper;
import com.hospital.hospitalmanagementsystem.service.IPatientsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author asfand
 * @since 2024-11-12
 */
@Service
public class PatientsServiceImpl extends ServiceImpl<PatientsMapper, Patients> implements IPatientsService {

}
