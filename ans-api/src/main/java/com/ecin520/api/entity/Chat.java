package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
@Accessors(chain = true)
public class Chat implements Serializable {

    private Integer id;
    private Integer send_id;
    private Integer receive_id;
    private String content;
    private Integer read_status;
    private String time;

}
