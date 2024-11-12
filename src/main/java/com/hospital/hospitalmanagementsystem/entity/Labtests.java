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
public class Labtests implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "lab_test_id", type = IdType.AUTO)
    private Long labTestId;

    private Long patientId;

    private Long labTechnicianId;

    private String testType;

    private LocalDate testDate;

    private String results;

    private String status;
}
