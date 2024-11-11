package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("lab_results")
public class LabResults implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "result_id", type = IdType.AUTO)
    private Integer resultId;

    private Integer patientId;

    private Integer testId;

    private LocalDate dateConducted;

    private String results;

    private Integer technicianId;
}
