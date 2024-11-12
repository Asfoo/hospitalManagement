package com.hospital.hospitalmanagementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Diagnosis;
import com.hospital.hospitalmanagementsystem.entity.Prescriptions;
import com.hospital.hospitalmanagementsystem.entity.Users;

public interface DoctorService extends IService<Users> {
    ResultMessage viewPatients(Long doctorId);
    ResultMessage addDiagnosis(Long doctorId, Diagnosis diagnosis);
    ResultMessage prescribeMedication(Long doctorId, Prescriptions prescription);
}

