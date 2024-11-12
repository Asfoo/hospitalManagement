package com.hospital.hospitalmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Appointments;
import com.hospital.hospitalmanagementsystem.entity.Patients;
import com.hospital.hospitalmanagementsystem.mapper.PatientsMapper;
import com.hospital.hospitalmanagementsystem.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Appointments;
import com.hospital.hospitalmanagementsystem.entity.Patients;
import com.hospital.hospitalmanagementsystem.mapper.PatientsMapper;
import com.hospital.hospitalmanagementsystem.service.IPatientsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
@Service
public class PatientsServiceImpl extends ServiceImpl<PatientsMapper, Patients> implements IPatientsService {

    @Autowired
    private PatientsMapper patientMapper;

    @Override
    public ResultMessage viewProfile(Long patientId) {
        QueryWrapper<Patients> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        Patients patient = patientMapper.selectOne(queryWrapper);
        return patient != null ? ResultMessage.success("Profile fetched successfully", patient)
                : ResultMessage.error("Patient not found");
    }

    @Override
    public ResultMessage updateProfile(Long patientId, Patients patientDetails) {
        patientDetails.setPatientId(patientId);
        int result = patientMapper.updateById(patientDetails);
        return result > 0 ? ResultMessage.success("Profile updated successfully")
                : ResultMessage.error("Update failed");
    }

    @Override
    public ResultMessage viewAppointments(Long patientId) {
        QueryWrapper<Appointments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        List<Appointments> appointments = patientMapper.selectList(queryWrapper);
        return ResultMessage.success("Appointments retrieved", appointments);
    }

    @Override
    public ResultMessage bookAppointment(Long patientId, Appointments appointmentDetails) {
        appointmentDetails.setPatientId(Math.toIntExact(patientId));
        int result = patientMapper.insert(appointmentDetails);
        return result > 0 ? ResultMessage.success("Appointment booked successfully")
                : ResultMessage.error("Booking failed");
    }    

    @Override
    public ResultMessage cancelAppointment(Long patientId, Long appointmentId) {
        int result = patientMapper.deleteAppointment(patientId, appointmentId);
        return result > 0 ? ResultMessage.success("Appointment cancelled successfully")
                : ResultMessage.error("Failed to cancel appointment");
    }

    @Override
    public ResultMessage viewMedicalHistory(Long patientId) {
        List<MedicalRecords> medicalRecords = patientMapper.selectMedicalHistoryByPatientId(patientId);
        return ResultMessage.success("Medical history retrieved", medicalRecords);
    }

    @Override
    public ResultMessage viewTestResults(Long patientId) {
        List<TestResult> testResults = patientMapper.selectTestResultsByPatientId(patientId);
        return ResultMessage.success("Test results retrieved", testResults);
    }

    @Override
    public ResultMessage viewBilling(Long patientId) {
        List<BillingRecord> billingRecords = patientMapper.selectBillingByPatientId(patientId);
        return ResultMessage.success("Billing information retrieved", billingRecords);
    }
}
