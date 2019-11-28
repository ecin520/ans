package com.ecin520.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String telNumber;
    private String rank;
    private String sign;
    private Integer status;
    private Integer ansNumber;
    private Integer correctNumber;
    private String goodAt;
    private String registerTime;

}
