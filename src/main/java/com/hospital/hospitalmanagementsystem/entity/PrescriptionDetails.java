package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@Accessors(chain = true)
@TableName("prescription_details")

public class PrescriptionDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "prescription_detail_id", type = IdType.AUTO)
    private Integer prescriptionDetailId;

    private Integer prescriptionId;

    private Integer medicationId;

    private String dosage;

    private Integer quantity;
}
