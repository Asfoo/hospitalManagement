package com.hospital.hospitalmanagementsystem.controller;

import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.entity.Diagnosis;
import com.hospital.hospitalmanagementsystem.entity.Prescriptions;
import com.hospital.hospitalmanagementsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{doctorId}/patients")
    public ResultMessage viewPatients(@PathVariable Long doctorId) {
        return doctorService.viewPatients(doctorId);
    }

    @PostMapping("/{doctorId}/add-diagnosis")
    public ResultMessage addDiagnosis(@PathVariable Long doctorId, @RequestBody Diagnosis diagnosis) {
        return doctorService.addDiagnosis(doctorId, diagnosis);
    }

    @PostMapping("/{doctorId}/prescribe-medication")
    public ResultMessage prescribeMedication(@PathVariable Long doctorId, @RequestBody Prescriptions prescription) {
        return doctorService.prescribeMedication(doctorId, prescription);
    }
}

