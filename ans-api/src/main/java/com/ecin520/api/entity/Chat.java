package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
public class Chat implements Serializable {

    private Integer id;
    private Integer send_id;
    private Integer receive_id;
    private String content;
    private String message_time;

}
