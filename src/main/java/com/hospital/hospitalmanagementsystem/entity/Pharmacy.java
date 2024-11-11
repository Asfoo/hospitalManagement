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

public class Pharmacy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "medication_id", type = IdType.AUTO)
    private Integer medicationId;

    private String name;

    private Integer stockQuantity;

    private LocalDate expirationDate;

    private Integer reorderLevel;
}
