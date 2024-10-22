package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author NICE
 * 好友表
 * id：自增id
 * sid：自己的id
 * oid：对方id
 * addTime：添加好友的时间
 */
@Data
@Accessors(chain = true)
public class Friend implements Serializable {

    private Integer id;
    private Integer sid;
    private Integer oid;
    private String add_time;

}
