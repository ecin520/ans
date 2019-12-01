package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author NICE
 * 验证表
 */
@Data
@Accessors(chain = true)
public class Verification implements Serializable {
    private Integer id;
    private Integer send_id;
    private Integer receive_id;
    private String ver_time;
    private Integer ver_status;

}
