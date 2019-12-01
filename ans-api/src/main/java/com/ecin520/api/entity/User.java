package com.ecin520.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author NICE
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String avatar_url;
    private String tel_number;
    private String rank;
    private String sign;
    private Integer status;
    private Integer ans_number;
    private Integer correct_number;
    private String good_at;
    private String register_time;

}
