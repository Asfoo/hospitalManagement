package com.hospital.hospitalmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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

public class Billing implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bill_id", type = IdType.AUTO)
    private Long billId;

    private Long patientId;

    private Long appointmentId;

    private BigDecimal totalAmount;

    private BigDecimal paidAmount;

    private LocalDate dueDate;

    private String status;
}
