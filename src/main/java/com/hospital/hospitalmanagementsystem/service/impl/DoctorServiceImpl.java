package com.hospital.hospitalmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Diagnosis;
import com.hospital.hospitalmanagementsystem.entity.Patients;
import com.hospital.hospitalmanagementsystem.entity.Prescriptions;
import com.hospital.hospitalmanagementsystem.entity.Users;
import com.hospital.hospitalmanagementsystem.mapper.DiagnosisMapper;
import com.hospital.hospitalmanagementsystem.mapper.PatientsMapper;
import com.hospital.hospitalmanagementsystem.mapper.PrescriptionsMapper;
import com.hospital.hospitalmanagementsystem.mapper.UsersMapper;
import com.hospital.hospitalmanagementsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorServiceImpl extends ServiceImpl<UsersMapper, Users> implements DoctorService {

    @Autowired
    private PatientsMapper patientMapper;
    @Autowired
    private DiagnosisMapper diagnosisMapper;
    @Autowired
    private PrescriptionsMapper prescriptionMapper;

    // Retrieve all patients assigned to a specific doctor
    @Override
    public ResultMessage viewPatients(Long doctorId) {
        QueryWrapper<Patients> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor_id", doctorId); // Assuming each patient has a `doctor_id` field
        List<Patients> patients = patientMapper.selectList(queryWrapper);
        return ResultMessage.success("Patients retrieved", patients);
    }

    // Add a diagnosis for a patient by the doctor
    @Override
    public ResultMessage addDiagnosis(Long doctorId, Diagnosis diagnosis) {
        diagnosis.setDoctorId(doctorId); // Set the doctor_id for the diagnosis
        diagnosis.setDiagnosisDate(LocalDate.now()); // Set the diagnosis date to current date
        int result = diagnosisMapper.insert(diagnosis);
        return result > 0 ? ResultMessage.success("Diagnosis added") : ResultMessage.error("Failed to add diagnosis");
    }

    // Prescribe medication for a patient by the doctor
    @Override
    public ResultMessage prescribeMedication(Long doctorId, Prescriptions prescription) {
        prescription.setDoctorId(doctorId); // Set the doctor_id for the prescription
        prescription.setDatePrescribed(LocalDate.now()); // Set the prescription date
        int result = prescriptionMapper.insert(prescription);
        return result > 0 ? ResultMessage.success("Medication prescribed") : ResultMessage.error("Prescription failed");
    }
}
