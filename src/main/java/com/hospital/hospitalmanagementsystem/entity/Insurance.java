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
@Accessors(chain = true)
public class Insurance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "insurance_id", type = IdType.AUTO)
    private Integer insuranceId;

    private String providerName;

    private String policyNumber;

    private String coverage;
}
