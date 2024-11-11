package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("lab_tests")

public class LabTests implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "test_id", type = IdType.AUTO)
    private Integer testId;

    private String testName;

    private String description;

    private BigDecimal cost;
}
