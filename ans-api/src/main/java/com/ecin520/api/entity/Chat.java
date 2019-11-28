package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
public class Chat implements Serializable {

    private Integer id;
    private Integer sendId;
    private Integer receiveId;
    private String content;
    private String messageTime;

}
