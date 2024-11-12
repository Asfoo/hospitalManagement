package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "appointment_id", type = IdType.AUTO)
    private Long appointmentId;

    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentDate;

    private String status;

    private String notes;
}
