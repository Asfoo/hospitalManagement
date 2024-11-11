package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author asfand
 * @since 2024-11-11
 */
@Getter
@Setter
@Accessors(chain = true)

public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "patient_id", type = IdType.AUTO)
    private Integer patientId;

    private String name;

    private LocalDate dateOfBirth;

    private String gender;

    private String contactNumber;

    private String email;

    private String address;

    private Integer insuranceId;

    private String emergencyContact;

    private String emergencyPhone;
}
