package com.hospital.hospitalmanagementsystem.service;

import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Appointments;
import com.hospital.hospitalmanagementsystem.entity.Patients;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
public interface IPatientsService extends IService<Patients> {
    ResultMessage viewProfile(Long patientId);
    ResultMessage updateProfile(Long patientId, Patients patientDetails);
    ResultMessage viewAppointments(Long patientId);
    ResultMessage bookAppointment(Long patientId, Appointments appointmentDetails);
    ResultMessage cancelAppointment(Long patientId, Long appointmentId);
    ResultMessage viewMedicalHistory(Long patientId);
    ResultMessage viewTestResults(Long patientId);
    ResultMessage viewBilling(Long patientId);
}
