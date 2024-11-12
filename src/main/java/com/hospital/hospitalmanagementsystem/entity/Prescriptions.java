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
 * @since 2024-11-12
 */
@Getter
@Setter
@Accessors(chain = true)

public class Prescriptions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "prescription_id", type = IdType.AUTO)
    private Long prescriptionId;

    private Long patientId;

    private Long doctorId;

    private LocalDate datePrescribed;

    private String medication;

    private String dosage;

    private String duration;

    private String instructions;
}
