package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 * 验证表
 */
@Data
public class Verification implements Serializable {
    private Integer id;
    private String sendId;
    private String receive_id;
    private String ver_time;
    private String ver_status;

}
