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
 * @since 2024-11-11
 */
@Getter
@Setter
@Accessors(chain = true)

public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "notification_id", type = IdType.AUTO)
    private Integer notificationId;

    private Integer userId;

    private String message;

    private LocalDateTime dateCreated;

    private String status;
}
