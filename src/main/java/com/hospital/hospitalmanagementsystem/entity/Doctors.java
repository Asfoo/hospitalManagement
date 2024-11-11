package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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

public class Doctors implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "doctor_id", type = IdType.AUTO)
    private Integer doctorId;

    private String specialization;

    private String availability;

    private Integer userId;
}
