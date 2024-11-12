package com.hospital.hospitalmanagementsystem.controller;

import com.hospital.hospitalmanagementsystem.dto.ResultMessage;
import com.hospital.hospitalmanagementsystem.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
@Controller
@RequestMapping("/patients")
public class PatientsController {
    @Autowired
    private IPatientsService patientService;

    // 1. View Personal Profile
    @GetMapping("/profile/{patientId}")
    public ResultMessage viewProfile(@PathVariable Long patientId) {
        return patientService.viewProfile(patientId);
    }

    // 2. Update Profile
    @PutMapping("/profile/{patientId}")
    public ResultMessage updateProfile(@PathVariable Long patientId, @RequestBody Patients patientDetails) {
        return patientService.updateProfile(patientId, patientDetails);
    }

    // 3. View Appointments
    @GetMapping("/{patientId}/appointments")
    public ResultMessage viewAppointments(@PathVariable Long patientId) {
        return patientService.viewAppointments(patientId);
    }

    // 4. Book Appointment
    @PostMapping("/{patientId}/appointments")
    public ResultMessage bookAppointment(@PathVariable Long patientId, @RequestBody Appointments appointmentDetails) {
        return patientService.bookAppointment(patientId, appointmentDetails);
    }

    // 5. Cancel Appointment
    @DeleteMapping("/{patientId}/appointments/{appointmentId}")
    public ResultMessage cancelAppointment(@PathVariable Long patientId, @PathVariable Long appointmentId) {
        return patientService.cancelAppointment(patientId, appointmentId);
    }

    // 6. View Medical History
    @GetMapping("/{patientId}/medical-history")
    public ResultMessage viewMedicalHistory(@PathVariable Long patientId) {
        return patientService.viewMedicalHistory(patientId);
    }

    // 7. View Test Results
    @GetMapping("/{patientId}/test-results")
    public ResultMessage viewTestResults(@PathVariable Long patientId) {
        return patientService.viewTestResults(patientId);
    }

    // 8. View Billing Information
    @GetMapping("/{patientId}/billing")
    public ResultMessage viewBilling(@PathVariable Long patientId) {
        return patientService.viewBilling(patientId);
    }

}
