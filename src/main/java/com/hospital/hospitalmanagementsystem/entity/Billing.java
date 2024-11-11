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
 * @since 2024-11-11
 */
@Getter
@Setter
public class Billing implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bill_id", type = IdType.AUTO)
    private Integer billId;

    private Integer patientId;

    private Integer appointmentId;

    private BigDecimal totalAmount;

    private String paymentStatus;

    private LocalDate paymentDate;
}
